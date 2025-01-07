import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }
    
    public void addHistory(HistoryItem item) throws SQLException {
        String query = "INSERT INTO history (input_value, from_unit, result_value, to_unit) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setDouble(1, item.getInputValue());
                stmt.setString(2, item.getFromUnit());
                stmt.setDouble(3, item.getResultValue());
                stmt.setString(4, item.getToUnit());
                stmt.executeUpdate();
            }
        }
    
        public List<HistoryItem> getHistory() throws SQLException {
            List<HistoryItem> historyList = new ArrayList<>();
            String query = "SELECT * FROM history";
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    HistoryItem item = new HistoryItem(
                        rs.getInt("id"),
                        rs.getDouble("input_value"),
                        rs.getString("from_unit"),
                        rs.getDouble("result_value"),
                        rs.getString("to_unit")
                    );
                    historyList.add(item);
                }
            }
            return historyList;
        }
        public void updateHistory(HistoryItem item) throws SQLException {
            String query = "UPDATE history SET input_value = ?, from_unit = ?, result_value = ?, to_unit = ? WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setDouble(1, item.getInputValue());
                stmt.setString(2, item.getFromUnit());
                stmt.setDouble(3, item.getResultValue());
                stmt.setString(4, item.getToUnit());
                stmt.setInt(5, item.getId());
                stmt.executeUpdate();
            }        }
    
        public void deleteHistory(int id) throws SQLException {
            String query = "DELETE FROM history WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        }
    
        public void close() throws SQLException {
            if (connection != null) {
                connection.close();
            }
        }

        public void executeUpdate(String query) throws SQLException {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(query);
            }
        }
    }