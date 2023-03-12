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

    public ResponseEntity<String> addOrder(Customer customer,int pizzaId) {
        try {
           Pizza pizza = pizzaDao.getPizzaById(pizzaId);
            String PizzaName= pizza.getPizzaName();
            System.out.println(PizzaName);
            customerDao.addCustomer(customer);

            // Create a new instance of Order using the customer and pizza information
            Order order = new Order(customer, pizzaId, PizzaName);

            // Insert the order into the database using the OrderDao
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
