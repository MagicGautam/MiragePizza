package com.MiragePizza.Beta.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.MiragePizza.Beta.Customer.Customer;

@Repository
public class OrderDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Customer customer = new Customer(
                    resultSet.getInt("CustomerID"),
                    resultSet.getString("CustomerName"),
                    resultSet.getString("CustomerPhone"),
                    resultSet.getString("CustomerEmail"),
                    resultSet.getString("CustomerAddress")
            );
            Order order = new Order(
                    customer,
                    resultSet.getInt("PizzaID"),
                    resultSet.getString("PizzaName")
            );
            order.setOrderID(resultSet.getInt("OrderID"));
            order.setOrderTime(resultSet.getTimestamp("OrderTime"));
            order.setTotalPrice(resultSet.getInt("TotalPrice"));
            return order;
        });
    }

    public void addOrder(Order order) {
        String sql = "INSERT INTO orders (CustomerName, CustomerPhone, CustomerEmail, CustomerAddress, PizzaID, PizzaName, OrderTime, TotalPrice, CustomerID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Customer Customer=order.getCustomer();
        jdbcTemplate.update(sql,  Customer.getCustomerName(), Customer.getCustomerPhone(), Customer.getCustomerEmail(), Customer.getCustomerAddress(), order.getPizzaID(), order.getPizzaName(), order.getOrderTime(), order.getTotalPrice(), Customer.getCustomerID());
    }
}