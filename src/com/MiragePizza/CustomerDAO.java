package com.MiragePizza;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class CustomerDAO {
    
    private Connection connection;

    public CustomerDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/MiragePizza";
            String username = "root";
            String password = "Gautam@123";
            connection = DriverManager.getConnection(url, username, password);
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOrder(String customerName, String customerPhone, String email, String address, int pizzaId, String pizzaName, int totalPrice) {
        try {
            // Create a PreparedStatement with an SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO orders (CustomerName, CustomerPhone, CustomerEmail, CustomerAddress, PizzaID, PizzaName, OrderTime, TotalPrice) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, customerPhone);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, pizzaId);
            preparedStatement.setString(6, pizzaName);
            preparedStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setDouble(8, totalPrice);
            
            // Execute the query
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}