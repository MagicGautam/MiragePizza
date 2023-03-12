package com.MiragePizza.Beta.Pizza;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PizzaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pizza> getAllPizzas() {
        String sql = "SELECT * FROM Pizza";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Pizza pizza = new Pizza();
            pizza.setPizzaID(resultSet.getInt("PizzaID"));
            pizza.setPizzaName(resultSet.getString("PizzaName"));
            pizza.setPizzaDescription(resultSet.getString("PizzaDescription"));
            pizza.setPizzaPrice(resultSet.getInt("PizzaPrice"));
            return pizza;
        });
    }
    public Pizza getPizzaById(int id) {
    	String sql = "SELECT * FROM Pizza WHERE PizzaID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            Pizza pizza = new Pizza();
            pizza.setPizzaID(resultSet.getInt("PizzaID"));
            pizza.setPizzaName(resultSet.getString("PizzaName"));
            pizza.setPizzaPrice(resultSet.getInt("PizzaPrice"));
            pizza.setPizzaDescription(resultSet.getString("PizzaDescription"));
            return pizza;
        });
    }
}