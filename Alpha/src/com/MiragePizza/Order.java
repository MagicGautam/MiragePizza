package com.MiragePizza;

class Order{

	public Order(Customer customer, int PizzaID, String PizzaName,int TotalPrice)
	{
		String CustomerName=customer.getName();
		String CustomerEmail=customer.getEmail();
		String CustomerPhone=customer.getPhoneno();
		String CustomerAddress=customer.getAddress();
		CustomerDAO cd=new CustomerDAO();
		cd.insertOrder(CustomerName,CustomerPhone,CustomerEmail,CustomerAddress,PizzaID,PizzaName,TotalPrice);
		System.out.println("ORDER SUCCESS!!");
		
	}
	
}
