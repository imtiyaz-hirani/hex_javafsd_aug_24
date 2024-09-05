package com.hibernate.main;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.hibernate.main.enums.RoleType;
import com.hibernate.main.model.Customer;
import com.hibernate.main.model.User;
import com.hibernate.main.service.CustomerService;
import com.hibernate.main.service.UserService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

//JPA: jakarta Persistence API 

public class App {

	public static void main(String[] args) {
		/* 
		 * our DB connection settings is in persistence.xml file.
		 * We need to reach out to this file from our java class. 
		 * 
		 * we use Persistence class and EntityManagerFactory interface and connect to persistence unit (ecomUnit)
		 */
		
		SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("booking_platform");
		
		/*Set up EntityManager*/
		EntityManager entityManager = sessionFactory.createEntityManager();
		 
		/*Set up EntityTransaction */
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Scanner sc = new Scanner(System.in);
		CustomerService customerService = new CustomerService(entityManager,entityTransaction);
		UserService userService = new UserService(entityManager,entityTransaction);
		
		while(true) {
			System.out.println("--------------Main Menu: ECOM--------------");
			System.out.println("1. Customer SignUp");
			System.out.println("0. Exit");
			int input = sc.nextInt();
			if(input == 0 ) {
				System.out.println("Exiting, thank you!!!");
				break; //breaks the while loop 
			}
			
			switch(input) {
				case 1: 
					Customer customer = new Customer();
					User user = new User();
					System.out.println("-----------------personal Info----------------");
					System.out.println("Enter name");
					customer.setName(sc.next());
					System.out.println("Enter contact");
					customer.setContact(sc.next());
					
					System.out.println("-----Set up your credentials for login--------");
					System.out.println("Enter username/email");
					user.setUsername(sc.next());
					System.out.println("Enter password");
					user.setPassword(sc.next());
					user.setRole(RoleType.CUSTOMER);
					//assign user to customer 
					customer.setUser(user);
					
				try {
					customerService.addCustomer(customer);
					System.out.println("Customer SignUp Done... ");
				} catch (Exception e) {
					 System.out.println("Op Failed " + e.getMessage());
				}		
				System.out.println("--------------------------------------------------");
					
					break;
				default: 
					break; 
			}
		}
		
		sc.close();
	}

}

/*
 * 
 * EntityManagerFactory
 *  	|
 *  SessionFactory 
 * 
 */