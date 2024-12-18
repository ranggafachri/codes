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

public class ConverterController extends Converter{

    @FXML
    private TextField Hasil;

    @FXML
    private TextField Isian;

    @FXML
    private Button Thapus;

    @FXML
    private Button Tkonvert;

    @FXML
    private ComboBox<String> Tpilihanhasil;

    @FXML
    private ComboBox<String> Tpilihanisi;

    @FXML
    private ComboBox<String> Tpilihankonvert;

    @FXML
    private Button Tupdate;

    @FXML
    private TableView<HistoryItem> history;

    @FXML
    private TableColumn<HistoryItem, Integer> no;

    @FXML
    private TableColumn<HistoryItem, Double> input;

    @FXML
    private TableColumn<HistoryItem, String> inputunit;

    @FXML
    private TableColumn<HistoryItem, Double> output;

    @FXML
    private TableColumn<HistoryItem, String> outputunit;

    private DatabaseManager dbManager;
    private ObservableList<HistoryItem> historyList;

    @FXML
    void Pilihanhasil(ActionEvent event) {

    }

    @FXML
    void Pilihanisi(ActionEvent event) {

    }

    @FXML
    void Pilihankonvert(ActionEvent event) {

    }
    public void initialize() {
        Tpilihankonvert.setItems(FXCollections.observableArrayList("Panjang", "Berat", "Suhu", "Waktu"));

    Tpilihankonvert.valueProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue.equals("Panjang")) {
            Tpilihanisi.setItems(FXCollections.observableArrayList("Meter", "Kilometer", "Centimeter"));
            Tpilihanhasil.setItems(FXCollections.observableArrayList("Meter", "Kilometer", "Centimeter"));
        } else if (newValue.equals("Berat")) {
            Tpilihanisi.setItems(FXCollections.observableArrayList("Gram", "Kilogram", "Miligram"));
            Tpilihanhasil.setItems(FXCollections.observableArrayList("Gram", "Kilogram", "Miligram"));
        } else if (newValue.equals("Suhu")) {
            Tpilihanisi.setItems(FXCollections.observableArrayList("Celcius", "Kelvin", "Fahrenheit", "Reamur"));
            Tpilihanhasil.setItems(FXCollections.observableArrayList("Celcius", "Kelvin", "Fahrenheit", "Reamur"));
        } else if (newValue.equals("Waktu")) {
            Tpilihanisi.setItems(FXCollections.observableArrayList("Detik", "Menit", "Jam", "Hari"));
            Tpilihanhasil.setItems(FXCollections.observableArrayList("Detik", "Menit", "Jam", "Hari"));
        } else {
            Tpilihanisi.setItems(FXCollections.observableArrayList());
            Tpilihanhasil.setItems(FXCollections.observableArrayList());
        }
    });

        historyList = FXCollections.observableArrayList();
        history.setItems(historyList);
        no.setCellValueFactory(new PropertyValueFactory<>("id"));
        input.setCellValueFactory(new PropertyValueFactory<>("inputValue"));
        inputunit.setCellValueFactory(new PropertyValueFactory<>("fromUnit"));
        output.setCellValueFactory(new PropertyValueFactory<>("resultValue"));
        outputunit.setCellValueFactory(new PropertyValueFactory<>("toUnit"));

        
        try {
            dbManager = new DatabaseManager("jdbc:mysql://localhost:3306/konverter_db", "root", "");
            loadHistory();
        } catch (SQLException e) {
            System.err.println("Error initializing DatabaseManager: " + e.getMessage());
        }
    }

    @FXML
    void konvert(ActionEvent event) {
        try {
            String fromUnit = Tpilihanisi.getValue();
            String toUnit = Tpilihanhasil.getValue();
            String convertType = Tpilihankonvert.getValue();
            double inputValue = Double.parseDouble(Isian.getText());

            if (fromUnit == null || toUnit == null || convertType == null) {
                System.err.println("Error: Ensure all fields are filled.");
                return;
            }

            double resultValue = convertValue(inputValue, fromUnit, toUnit);
            Hasil.setText(String.valueOf(resultValue));

            HistoryItem newItem = new HistoryItem(0, inputValue, fromUnit, resultValue, toUnit);
            dbManager.addHistory(newItem);
            loadHistory();
        } catch (NumberFormatException e) {
            System.err.println("Error: Input must be a valid number.");
        } catch (SQLException e) {
            System.err.println("Error saving to database: " + e.getMessage());
        }
    }

    @FXML
    void hapus(ActionEvent event) {
        HistoryItem selectedItem = history.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            System.err.println("Error: No item selected.");
            return;
        }

        try {
            dbManager.deleteHistory(selectedItem.getId());
            dbManager.executeUpdate("ALTER TABLE history AUTO_INCREMENT = 1");
            loadHistory(); 
        } catch (SQLException e) {
            System.err.println("Error deleting history: " + e.getMessage());
        }
    }

    @FXML
    void update(ActionEvent event) {
        HistoryItem selectedItem = history.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            System.err.println("Error: No item selected.");
            return;
        }
    
        try {
            double newInputValue = Double.parseDouble(Isian.getText());
            String newFromUnit = Tpilihanisi.getValue();
            String newToUnit = Tpilihanhasil.getValue();
    
            double newResultValue = convertValue(newInputValue, newFromUnit, newToUnit);
    
            selectedItem.setInputValue(newInputValue);
            selectedItem.setFromUnit(newFromUnit);
            selectedItem.setResultValue(newResultValue);
            selectedItem.setToUnit(newToUnit);
    
            Hasil.setText(String.valueOf(newResultValue));
            dbManager.updateHistory(selectedItem);
    
            loadHistory();
        } catch (NumberFormatException e) {
            System.err.println("Error: Input must be a valid number.");
        } catch (SQLException e) {
            System.err.println("Error updating history: " + e.getMessage());
        }
    }
    

    private void loadHistory() {
        try {
            historyList.clear();
            historyList.addAll(dbManager.getHistory());
        } catch (SQLException e) {
            System.err.println("Error loading history: " + e.getMessage());
        }
    }
}
