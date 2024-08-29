package com.main.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

import com.main.dto.ProductDto;
import com.main.model.Customer;
import com.main.model.Product;
import com.main.service.CustomerService;
import com.main.service.ProductService;

public class CustomerController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		CustomerService customerService = new CustomerService();
		ProductService productService = new ProductService();
		
		while(true)
		{	
			System.out.println("1. Fetch all customer along with their address");
			System.out.println("2. Fetch all products bought by given customer");
			System.out.println("3. Buy Product");
			System.out.println("0. To Exit");
			int input = sc.nextInt();
			if(input == 0 ) {
				System.out.println("Exiting, thank you... ");
				break; //while loop breaks 
			}
			
			switch(input) {
				case 1: 
				
				try {
					List<Customer> list = customerService.fetchCustomerWithAddress();
					System.out.println("-----------------------------------------------------");
					list.stream()
							.forEach(c-> System.out.println(c.getName() + "\t" + c.getAddress().getCity() 
									  + "\t" + c.getAddress().getStreetAddress() ));
					 
					System.out.println("-----------------------------------------------------");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
					break; 
  				case 2: 
				try {
					List<Customer> list = customerService.fetchCustomerWithAddress();
					System.out.println("------------List of Customers-----------------");
					list.stream()
					.forEach(c-> System.out.println(c.getId() + "\t" + c.getName() + "\t\t" 
								+ c.getAddress().getCity()));
					
					System.out.println("Select customer_id to see products bought");
					int cid = sc.nextInt();
					List<ProductDto> pList = productService.fetchProductsByCustomerId(cid);
					/* Given 
					 * List: List<Customer>  
					 * id: cid  
					 * using filter fetch matching customerObj based on this id 
					 * */
					
					Stream<Customer> cStream = list.stream()
							.filter(cust-> cust.getId() == cid);
					
					Optional<Customer> optional = cStream.findFirst();
					if(optional.isEmpty()) {
						System.out.println("Cusomter ID Invalid; ");
						break; 
					}
					Customer customeObjr = optional.get();
					System.out.println("Customer Name: " + customeObjr.getName());
					pList.stream()
						.forEach(p-> System.out.println(p.getTitle() + "\t" 
								 + p.getPrice() + "\t" 
								 + p.getDateOfPurchase() + "\t" 
								 + p.getVendorName()));
					System.out.println("--------------------------------------------------");
 			
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
  					
					break; 
					
  				case 3: 
  					System.out.println("-------------All Products-------------");
				
				try {
					List<Product> list  = productService.getAll();
					list.stream()
						.forEach(p-> 
							System.out.println(p.getId() + "  " 
												+ p.getTitle() + "  " 
												+ p.getPrice() + "  " 
												+ p.getDiscount()) );
					Map<Integer, Integer> map = new HashMap<>();
					
					int flag = 0; 
					while(true) {
						System.out.println("Select Product id to buy or 0 to go to main menu");
						int pid = sc.nextInt();
						if(pid == 0) {
							flag = 1;
							break; 
						}
						System.out.println("Enter product quantity ");
						int qty = sc.nextInt();
						map.put(pid, qty);
						System.out.println("To buy another product Press 1 else Press 0 to go to Checkout");
						int resp = sc.nextInt();
						if(resp == 0) {
							break; 
						}
					}
					if(flag != 1) {
						System.out.println("****CHECK OUT*****");
						System.out.println(map);
					}
					System.out.println("--------------------------------------------------");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
  					
  					break; 
				default:
					break; 
			}
				
		}
		
		
		/*
		 * List<Integer> list 
		 * 
		 * list.stream().forEach(x-> Sysout(x)) 
		 * 
		 * List<Product> list 
		 * list.stream().forEach(p-> Sysout(p.getId() + "  " + p.getTitle()))
		 * */
		
		sc.close();
	}
}
