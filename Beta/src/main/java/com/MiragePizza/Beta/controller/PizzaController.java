package com.MiragePizza.Beta.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.MiragePizza.Beta.Pizza.PizzaService;
import com.MiragePizza.Beta.Pizza.Pizza;

@RestController
public class PizzaController {
	private final PizzaService pizzaservice;

@Autowired
public PizzaController(PizzaService pizzaService) {
	 this.pizzaservice = pizzaService;
}
@GetMapping("/pizzas")
public List<Pizza> getAllPizzas() {
	return	pizzaservice.getAllPizzas();
}

@GetMapping("/pizzas/{id}")
public ResponseEntity<Pizza> getPizzaById(@PathVariable int id) throws SQLException {
    Pizza pizza = pizzaservice.getPizzaById(id);
    if (pizza == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(pizza);
}

}
