package com.MiragePizza.Beta.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.MiragePizza.Beta.Customer.Customer;
import com.MiragePizza.Beta.Customer.CustomerDao;
import com.MiragePizza.Beta.Pizza.Pizza;
import com.MiragePizza.Beta.Pizza.PizzaDao;

@Service
public class OrderService {
    private final OrderDao orderDao;
    private final CustomerDao customerDao;
    private final PizzaDao pizzaDao;

    @Autowired
    public OrderService(OrderDao orderDao, CustomerDao customerDao, PizzaDao pizzaDao) {
        this.orderDao = orderDao;
        this.customerDao = customerDao;
        this.pizzaDao = pizzaDao;
    }

    public ResponseEntity<String> addOrder(Customer customer, int pizzaId) {
        try {
            // Retrieve the Pizza object from the database based on the pizzaId
            Pizza pizza = pizzaDao.getPizzaById(pizzaId);
            
            // Create a new instance of Order using the customer and pizza information
            Order order = new Order(customer, pizzaId, pizza.getPizzaName());
            
            // Add the customer to the database using the CustomerDao
            customerDao.addCustomer(customer);
            
            // Add the order to the database using the OrderDao
            orderDao.addOrder(order);
            
            return ResponseEntity.ok().body("Order added successfully.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body("Error adding order.");
        }
    }

        public List<Order> getAllOrders() {
            return orderDao.getAllOrders();
        }
}
