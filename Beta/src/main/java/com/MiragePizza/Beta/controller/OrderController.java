package com.MiragePizza.Beta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MiragePizza.Beta.Customer.Customer;
import com.MiragePizza.Beta.Order.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> addOrder(@RequestBody Customer Customer, @RequestParam(name = "pizzaID", defaultValue = "1") int pizzaID) {
    // i used the default parameter so i can input pizzaID via the JSON Query and not required to input via URL. If no id specified then default is taken as 1.
        try {
            orderService.addOrder(Customer, pizzaID);
            return ResponseEntity.ok().body("Order added successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding order.");
        }
    }
}
