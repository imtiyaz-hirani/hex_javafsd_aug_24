package com.main.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.main.model.Customer;
import com.main.service.CustomerService;

public class CustomerController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		CustomerService customerService = new CustomerService();
		
		while(true)
		{	
			System.out.println("1. Fetch all customer along with their address");
			System.out.println("2. Fetch all products bought by given customer");
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
					for(Customer c : list) {
						System.out.println(c.getName() + "\t" + c.getAddress().getCity() + "\t" + c.getAddress().getStreetAddress() );
					}
					System.out.println("-----------------------------------------------------");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
					break; 
				case 2: 
					break; 
				default:
					break; 
			}
				
		}
		
		
		
		
		sc.close();
	}
}
