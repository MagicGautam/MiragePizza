package com.MiragePizza.Beta.Customer;
public class Customer{
	private int CustomerID;
	private String CustomerName;
	private String CustomerAddress;
	private String CustomerPhone;
	private String CustomerEmail;
	
	public Customer() {
		
	}
	public Customer(int customerID, String customerName, String customerAddress, String customerPhone,
			String customerEmail) {
		super();
		CustomerID = customerID;
		CustomerName = customerName;
		CustomerAddress = customerAddress;
		CustomerPhone = customerPhone;
		CustomerEmail = customerEmail;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerAddress() {
		return CustomerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}
	public String getCustomerPhone() {
		return CustomerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		CustomerPhone = customerPhone;
	}
	public String getCustomerEmail() {
		return CustomerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}
	

	
	
}