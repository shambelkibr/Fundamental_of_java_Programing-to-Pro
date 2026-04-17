package JDBC;

import java.sql.*;

public class EmployeeTableManager {
    private static final String URL = "jdbc:mysql://localhost:3306/northwind";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public static void main(String[] args) {
        createEmployeeTable();
        insertSampleData();
        displayAllEmployees();
    }
    
    public static void createEmployeeTable() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            
            String createTableSQL = """
                CREATE TABLE IF NOT EXISTS employTable (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(100) NOT NULL,
                    age INT,
                    address VARCHAR(255),
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
                """;
            
            statement.executeUpdate(createTableSQL);
            System.out.println("✅ Employee table created/verified successfully!");
            
        } catch (SQLException e) {
            System.err.println("❌ Error creating table: " + e.getMessage());
        }
    }
    
    public static void insertSampleData() {
        String insertSQL = "INSERT INTO employTable (name, age, address) VALUES (?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            
            // Insert sample employees
            String[][] employees = {
                {"John Doe", "30", "123 Main St, New York"},
                {"Jane Smith", "25", "456 Oak Ave, Los Angeles"},
                {"Mike Johnson", "35", "789 Pine Rd, Chicago"},
                {"Sarah Wilson", "28", "321 Elm St, Houston"}
            };
            
            for (String[] employee : employees) {
                pstmt.setString(1, employee[0]);
                pstmt.setInt(2, Integer.parseInt(employee[1]));
                pstmt.setString(3, employee[2]);
                pstmt.executeUpdate();
            }
            
            System.out.println("✅ Sample data inserted successfully!");
            
        } catch (SQLException e) {
            System.err.println("❌ Error inserting data: " + e.getMessage());
        }
    }
    
    public static void displayAllEmployees() {
        String selectSQL = "SELECT * FROM employTable";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            
            System.out.println("\n📊 Employee Records:");
            System.out.println("+----+--------------+-----+---------------------------+---------------------+");
            System.out.println("| ID | Name         | Age | Address                   | Created At          |");
            System.out.println("+----+--------------+-----+---------------------------+---------------------+");
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String createdAt = resultSet.getString("created_at");
                
                System.out.printf("| %-2d | %-12s | %-3d | %-25s | %-19s |\n", 
                    id, name, age, address, createdAt.substring(0, 19));
            }
            System.out.println("+----+--------------+-----+---------------------------+---------------------+");
            
        } catch (SQLException e) {
            System.err.println("❌ Error reading data: " + e.getMessage());
        }
    }
}