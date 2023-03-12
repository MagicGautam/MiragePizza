package com.MiragePizza.Beta.Order;

import com.MiragePizza.Beta.Customer.Customer;

public class OrderRequest {
    private Customer customer;
    private int pizzaId;

    public OrderRequest(Customer customer, int pizzaId) {
        this.customer = customer;
        this.pizzaId = pizzaId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }
}