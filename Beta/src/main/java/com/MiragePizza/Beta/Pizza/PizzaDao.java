package com.MiragePizza.Beta.Pizza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public Pizza getPizzaById(int PizzaID) throws SQLException {
        Connection conn = jdbcTemplate.getDataSource().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pizza pizza = null;

        try {
            String sql = "SELECT * FROM pizza WHERE PizzaID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, PizzaID);
            rs = ps.executeQuery();

            if (rs.next()) {
                pizza = new Pizza();
                pizza.setPizzaID(rs.getInt("PizzaID"));
                pizza.setPizzaName(rs.getString("PizzaName"));
                pizza.setPizzaPrice(rs.getInt("PizzaPrice"));
                pizza.setPizzaDescription(rs.getString("PizzaDescription"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return pizza;
    }
}