package com.MiragePizza.Beta.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CustomerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM Customers";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Customer customer = new Customer();
            customer.setCustomerID(resultSet.getInt("CustomerID"));
            customer.setCustomerName(resultSet.getString("CustomerName"));
            customer.setCustomerPhone(resultSet.getString("CustomerPhone"));
            customer.setCustomerEmail(resultSet.getString("CustomerEmail"));
            customer.setCustomerAddress(resultSet.getString("CustomerAddress"));
            return customer;
        });
    }

    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM Customers WHERE CustomerID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            Customer customer = new Customer();
            customer.setCustomerID(resultSet.getInt("CustomerID"));
            customer.setCustomerName(resultSet.getString("CustomerName"));
            customer.setCustomerPhone(resultSet.getString("CustomerPhone"));
            customer.setCustomerEmail(resultSet.getString("CustomerEmail"));
            customer.setCustomerAddress(resultSet.getString("CustomerAddress"));
            return customer;
        });
    }
    public int addCustomer(Customer customer) {
        String sql = "INSERT INTO Customers (CustomerName, CustomerPhone, CustomerEmail, CustomerAddress) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerPhone());
            ps.setString(3, customer.getCustomerEmail());
            ps.setString(4, customer.getCustomerAddress());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void updateCustomer(Customer customer) {
        String sql = "UPDATE Customers SET CustomerName = ?, CustomerPhone = ?, CustomerEmail = ?, CustomerAddress = ? WHERE CustomerID = ?";
        jdbcTemplate.update(sql, customer.getCustomerName(), customer.getCustomerPhone(), customer.getCustomerEmail(), customer.getCustomerAddress(), customer.getCustomerID());
    }

    public void deleteCustomer(int id) {
        String sql = "DELETE FROM Customers WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

	public void save(Customer customer) {
		// TODO Auto-generated method stub
		
	}
}