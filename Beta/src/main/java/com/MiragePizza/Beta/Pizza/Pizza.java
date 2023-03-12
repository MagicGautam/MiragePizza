package com.MiragePizza.Beta.Pizza;
public class Pizza {
	private int PizzaID;
	private String PizzaName;
	private String PizzaDescription;
	private int PizzaPrice;
	
	
	public int getPizzaID() {
		return PizzaID;
	}
	public void setPizzaID(int id) {
		this.PizzaID = id;
	}
	public String getPizzaName() {
		return PizzaName;
	}
	public void setPizzaName(String name) {
		PizzaName = name;
	}
	public String getPizzaDescription() {
		return PizzaDescription;
	}
	public void setPizzaDescription(String description) {
		this.PizzaDescription = description;
	}
	public int getPizzaPrice() {
		return PizzaPrice;
	}
	public void setPizzaPrice(int price) {
		this.PizzaPrice = price;
	}
	
}