package com.MiragePizza.Beta.Order;

import java.sql.Timestamp;

import com.MiragePizza.Beta.Customer.Customer;
import javax.persistence.GeneratedValue;

public class Order {
	@GeneratedValue private int OrderID;
	private Customer Customer;
    private int PizzaID;
    private String PizzaName;
    private int TotalPrice;
    private Timestamp OrderTime = new Timestamp(System.currentTimeMillis());

	
	public Order(Customer customer, int pizzaId, String pizzaName) {
		Customer = customer;
        PizzaID = pizzaId;
        PizzaName = pizzaName;
        OrderTime = new Timestamp(System.currentTimeMillis());
    }

	
	public Customer getCustomer() {
		return Customer;
	}


	public void setCustomer(Customer customer) {
		Customer = customer;
	}


	public Timestamp getOrderTime() {
		return OrderTime;
	}


	public void setOrderTime(Timestamp orderTime) {
		OrderTime = orderTime;
	}

	public int getOrderID() {
		return OrderID;
	}


	public void setOrderID(int orderID) {
		OrderID = orderID;
	}


	public int getPizzaID() {
		return PizzaID;
	}

	public void setPizzaID(int pizzaId2) {
		this.PizzaID = pizzaId2;
	}

	public String getPizzaName() {
		return PizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.PizzaName = pizzaName;
	}

	public int getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.TotalPrice = totalPrice;
	}
    
    
}