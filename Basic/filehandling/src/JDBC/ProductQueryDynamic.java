package JDBC;

import java.sql.*;
import java.util.Scanner;

public class ProductQueryDynamic {
    private static final String URL = "jdbc:mysql://localhost:3306/northwind";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter product ID to search: ");
        int searchId = scanner.nextInt();
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                 "SELECT productId, productName, price FROM products WHERE productId = ?")) {
            
            preparedStatement.setInt(1, searchId);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int productId = resultSet.getInt("productId");
                    String productName = resultSet.getString("productName");
                    double price = resultSet.getDouble("price");
                    
                    System.out.println("Product Details:");
                    System.out.println("ID: " + productId);
                    System.out.println("Name: " + productName);
                    System.out.println("Price: $" + price);
                } else {
                    System.out.println("No product found with ID: " + searchId);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}


// package JDBC;

// import java.sql.*;

// public class ProductQueryEnhanced {
//     private static final String URL = "jdbc:mysql://localhost:3306/northwind";
//     private static final String USERNAME = "root";
//     private static final String PASSWORD = "";
    
//     public static void main(String[] args) {
//         // Using try-with-resources for automatic resource management
//         try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//              PreparedStatement preparedStatement = connection.prepareStatement(
//                  "SELECT productId FROM products WHERE productId = ?")) {
            
//             // Set the parameter
//             preparedStatement.setInt(1, 14);
            
//             // Execute and process results
//             try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                 if (resultSet.next()) {
//                     int productId = resultSet.getInt("productId");
//                     System.out.println("✓ Product found with ID: " + productId);
//                 } else {
//                     System.out.println("✗ No product found with ID 14");
//                 }
//             }
            
//         } catch (SQLException e) {
//             System.err.println("Database error: " + e.getMessage());
//             e.printStackTrace();
//         }
//     }
// }