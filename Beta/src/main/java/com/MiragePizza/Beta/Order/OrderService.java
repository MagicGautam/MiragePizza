package com.MiragePizza.Beta.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/orders")
    public ResponseEntity<String> addOrder(@RequestBody Customer customer, @RequestParam int pizzaId) {
        try {
            // Get pizza name from pizzaId using the PizzaDao
            Pizza pizzaName = pizzaDao.getPizzaById(pizzaId);
            String PizzaName= pizzaName.getPizzaName();
            customerDao.addCustomer(customer);

            // Create a new instance of Order using the customer and pizza information
            Order order = new Order(customer, pizzaId, PizzaName);

            // Insert the order into the database using the OrderDao
            orderDao.addOrder(order);

            return ResponseEntity.ok().body("Order added successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding order.");
        }
    }
}