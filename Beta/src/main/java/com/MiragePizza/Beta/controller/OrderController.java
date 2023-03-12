package com.MiragePizza.Beta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiragePizza.Beta.Customer.Customer;
import com.MiragePizza.Beta.Order.Order;
import com.MiragePizza.Beta.Order.OrderRequest;
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
    public ResponseEntity<String> addOrder(@RequestBody OrderRequest request) {
    	   
    	Customer Customer = request.getCustomer();
 	   	int pizzaID = request.getPizzaId();
 	   	ResponseEntity<String> response = orderService.addOrder(Customer, pizzaID);
 	   	return response;
    
   }
    @GetMapping("/allorders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
