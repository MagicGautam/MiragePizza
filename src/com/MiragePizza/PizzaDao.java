package com.MiragePizza;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;

class PizzaDao{
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/MiragePizza";
	
	static final String USER = "root";
    static final String PASS = "Gautam@123";
    
    
    public List<Pizza> getAllPizzas() {
        List<Pizza> pizzas = new ArrayList<Pizza>();
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            
            //Returning the Pizzas as a List.
            sql = "SELECT * FROM pizza";
            ResultSet rs = stmt.executeQuery(sql);
            

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int price = rs.getInt("price");

                // Create Pizza object and add to list
                Pizza temppizza = new Pizza(id, name, description, price);
                pizzas.add(temppizza);
            }

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        }

        return pizzas;
    }
}