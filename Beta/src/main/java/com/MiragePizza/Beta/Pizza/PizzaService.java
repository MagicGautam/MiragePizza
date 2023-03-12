package com.MiragePizza.Beta.Pizza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired
    private PizzaDao pizzaDao;

    public PizzaService(PizzaDao pizzaDao) {
        this.pizzaDao = pizzaDao;
    }

    public List<Pizza> getAllPizzas() {
        return pizzaDao.getAllPizzas();
    }

	public Pizza getPizzaById(int id) {
        return pizzaDao.getPizzaById(id);
    }
}