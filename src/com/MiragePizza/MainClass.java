package com.MiragePizza;
import java.util.Scanner;  
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
	
		System.out.println("WELCOME TO MIRAGE PIZZA\n");
		System.out.println("=======================");
		System.out.println("Here is the Menu, Please Enter your choice\n\n");
		
		PizzaDao pd=new PizzaDao();
		List<Pizza> pizzaList= pd.getAllPizzas();
		for(Pizza pizza : pizzaList) {
		    System.out.println("ID: " + pizza.getId()+"  " + pizza.getName()+"  Price: " + pizza.getPrice());
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter your choice of Pizza please\n");
		int choice=sc.nextInt();
		sc.nextLine();
		Customer c1=new Customer();
		System.out.println("\n Enter your Details\n");
		System.out.println("===================");
		System.out.println("Enter Your Name\n");
		c1.setName(sc.nextLine());
	
		System.out.println("Enter Your Phone Number\n");
		c1.setPhone(sc.nextLine());	
		System.out.println("Enter Your Email\n");
		c1.setEmail(sc.nextLine());
		System.out.println("Enter Your Address\n");
		c1.setAddress(sc.nextLine());
		
		int totalprice=0;
		totalprice+=pizzaList.get(choice).getPrice();
		String PizzaName=pizzaList.get(choice).getName();
		Order o=new Order(c1, choice, PizzaName, totalprice);
		
		
	}

}
