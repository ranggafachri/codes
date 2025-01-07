import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.SQLException;
import java.util.Arrays;

public class ConverterController extends Converter {

    @FXML private TextField Hasil;
    @FXML private TextField Isian;
    @FXML private Button Thapus;
    @FXML private Button Tkonvert;
    @FXML private ComboBox<String> Tpilihanhasil;
    @FXML private ComboBox<String> Tpilihanisi;
    @FXML private ComboBox<String> Tpilihankonvert;
    @FXML private Button Tupdate;
    @FXML private TableView<HistoryItem> history;
    @FXML private TableColumn<HistoryItem, Integer> no;
    @FXML private TableColumn<HistoryItem, Double> input;
    @FXML private TableColumn<HistoryItem, String> inputunit;
    @FXML private TableColumn<HistoryItem, Double> output;
    @FXML private TableColumn<HistoryItem, String> outputunit;

    private DatabaseManager dbManager;
    private ObservableList<HistoryItem> historyList;

    @FXML
    public void initialize() {
        initializeComboBoxes();
        initializeTableColumns();
        initializeHistoryTable();
        initializeDatabaseConnection();
        setupHistorySelectionListener();
    }

    private void initializeComboBoxes() {
        Tpilihankonvert.setItems(FXCollections.observableArrayList("Panjang", "Berat", "Suhu", "Waktu"));
        
        Tpilihankonvert.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateUnitComboBoxes(newValue);
        });
    }

    private void updateUnitComboBoxes(String conversionType) {
        ObservableList<String> units;
        switch (conversionType) {
            case "Panjang":
                units = FXCollections.observableArrayList("Meter", "Kilometer", "Centimeter");
                break;
            case "Berat":
                units = FXCollections.observableArrayList("Gram", "Kilogram", "Miligram");
                break;
            case "Suhu":
                units = FXCollections.observableArrayList("Celcius", "Kelvin", "Fahrenheit", "Reamur");
                break;
            case "Waktu":
                units = FXCollections.observableArrayList("Detik", "Menit", "Jam", "Hari");
                break;
            default:
                units = FXCollections.observableArrayList();
        }
        Tpilihanisi.setItems(units);
        Tpilihanhasil.setItems(units);
    }

    private void initializeTableColumns() {
        no.setCellValueFactory(new PropertyValueFactory<>("id"));
        input.setCellValueFactory(new PropertyValueFactory<>("inputValue"));
        inputunit.setCellValueFactory(new PropertyValueFactory<>("fromUnit"));
        output.setCellValueFactory(new PropertyValueFactory<>("resultValue"));
        outputunit.setCellValueFactory(new PropertyValueFactory<>("toUnit"));
    }

    private void initializeHistoryTable() {
        historyList = FXCollections.observableArrayList();
        history.setItems(historyList);
    }

    private void initializeDatabaseConnection() {
        try {
            dbManager = new DatabaseManager("jdbc:mysql://localhost:3308/convertercalculator", "root", "");
            loadHistory();
        } catch (SQLException e) {
            System.err.println("Error initializing DatabaseManager: " + e.getMessage());
        }
    }

    private void setupHistorySelectionListener() {
        history.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateFieldsFromHistory(newSelection);
            }
        });
    }

    private void populateFieldsFromHistory(HistoryItem item) {
        Isian.setText(String.valueOf(item.getInputValue()));
        Hasil.setText(String.valueOf(item.getResultValue()));
        
        String conversionType = determineConversionType(item.getFromUnit());
        Tpilihankonvert.setValue(conversionType);
        
        javafx.application.Platform.runLater(() -> {
            Tpilihanisi.setValue(item.getFromUnit());
            Tpilihanhasil.setValue(item.getToUnit());
        });
    }

    private String determineConversionType(String unit) {
        if (Arrays.asList("Meter", "Kilometer", "Centimeter").contains(unit)) {
            return "Panjang";
        } else if (Arrays.asList("Gram", "Kilogram", "Miligram").contains(unit)) {
            return "Berat";
        } else if (Arrays.asList("Celcius", "Kelvin", "Fahrenheit", "Reamur").contains(unit)) {
            return "Suhu";
        } else if (Arrays.asList("Detik", "Menit", "Jam", "Hari").contains(unit)) {
            return "Waktu";
        }
        return "";
    }

    @FXML
    void konvert(ActionEvent event) {
        try {
            String fromUnit = Tpilihanisi.getValue();
            String toUnit = Tpilihanhasil.getValue();
            String convertType = Tpilihankonvert.getValue();
            
            if (!validateInputs(fromUnit, toUnit, convertType)) {
                return;
            }

            double inputValue = Double.parseDouble(Isian.getText());
            double resultValue = convertValue(inputValue, fromUnit, toUnit);
            
            Hasil.setText(String.valueOf(resultValue));
            Isian.clear();  

            saveToHistory(inputValue, fromUnit, resultValue, toUnit);
            
        } catch (NumberFormatException e) {
            System.err.println("Error: Input must be a valid number.");
        } catch (SQLException e) {
            System.err.println("Error saving to database: " + e.getMessage());
        }
    }

    private boolean validateInputs(String fromUnit, String toUnit, String convertType) {
        if (fromUnit == null || toUnit == null || convertType == null) {
            System.err.println("Error: Please select all conversion options.");
            return false;
        }
        if (Isian.getText().isEmpty()) {
            System.err.println("Error: Please enter a value to convert.");
            return false;
        }
        return true;
    }

    private void saveToHistory(double inputValue, String fromUnit, double resultValue, String toUnit) throws SQLException {
        HistoryItem newItem = new HistoryItem(0, inputValue, fromUnit, resultValue, toUnit);
        dbManager.addHistory(newItem);
        loadHistory();
    }

    @FXML
    void hapus(ActionEvent event) {
        HistoryItem selectedItem = history.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            System.err.println("Error: No item selected for deletion.");
            return;
        }

        try {
            dbManager.deleteHistory(selectedItem.getId());
            dbManager.executeUpdate("ALTER TABLE history AUTO_INCREMENT = 1");
            loadHistory();
            clearFields(); 
        } catch (SQLException e) {
            System.err.println("Error deleting history: " + e.getMessage());
        }
    }

    @FXML
    void update(ActionEvent event) {
        HistoryItem selectedItem = history.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            System.err.println("Error: No item selected for update.");
            return;
        }

        try {
            if (!validateInputs(Tpilihanisi.getValue(), Tpilihanhasil.getValue(), Tpilihankonvert.getValue())) {
                return;
            }

            double newInputValue = Double.parseDouble(Isian.getText());
            String newFromUnit = Tpilihanisi.getValue();
            String newToUnit = Tpilihanhasil.getValue();
            double newResultValue = convertValue(newInputValue, newFromUnit, newToUnit);

            Hasil.setText(String.valueOf(newResultValue));
            Isian.clear(); 

            updateHistoryItem(selectedItem, newInputValue, newFromUnit, newResultValue, newToUnit);
            loadHistory();
            
        } catch (NumberFormatException e) {
            System.err.println("Error: Input must be a valid number.");
        } catch (SQLException e) {
            System.err.println("Error updating history: " + e.getMessage());
        }
    }

    private void updateHistoryItem(HistoryItem item, double inputValue, String fromUnit, 
                                 double resultValue, String toUnit) throws SQLException {
        item.setInputValue(inputValue);
        item.setFromUnit(fromUnit);
        item.setResultValue(resultValue);
        item.setToUnit(toUnit);
        dbManager.updateHistory(item);
    }

    private void loadHistory() {
        try {
            historyList.clear();
            historyList.addAll(dbManager.getHistory());
        } catch (SQLException e) {
            System.err.println("Error loading history: " + e.getMessage());
        }
    }

    private void clearFields() {
        Isian.clear();
        Hasil.clear();
        Tpilihanisi.setValue(null);
        Tpilihanhasil.setValue(null);
        Tpilihankonvert.setValue(null);
    }

    @FXML void Pilihanhasil(ActionEvent event) {}
    @FXML void Pilihanisi(ActionEvent event) {}
    @FXML void Pilihankonvert(ActionEvent event) {}
}