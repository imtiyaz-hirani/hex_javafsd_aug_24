package com.hibernate.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.hibernate.main.dto.BusDto;
import com.hibernate.main.enums.RoleType;
import com.hibernate.main.model.Customer;
import com.hibernate.main.model.CustomerBusRoute;
import com.hibernate.main.model.Passenger;
import com.hibernate.main.model.User;
import com.hibernate.main.service.BusService;
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
		BusService busService = new BusService(entityManager,entityTransaction);
		
		while(true) {
			System.out.println("--------------Main Menu: ECOM--------------");
			System.out.println("1. Customer SignUp");
			System.out.println("2. Customer Login");
			System.out.println("3. Bus Bokking");
			
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
				case 2: 
					user = new User();
					System.out.println("-----------CUSTOMER LOGIN-------------");
					System.out.println("Enter username/email");
					user.setUsername(sc.next());
					System.out.println("Enter password");
					user.setPassword(sc.next());
					
					if(userService.login(user) == false) {
						System.out.println("Invalid Credentials!!! Try again.. ");
						break; 
					};
 					System.out.println("Press 1. Previous Bookings ");
 					System.out.println("Press 2. for enquiry");
 					System.out.println("Press 0 to back to main menu");
 					int cinput = sc.nextInt();
 					if(cinput == 0) {
 						break; 
 					}
 					switch(cinput) {
 						case 1: 
 							System.out.println("---------Previous Booking---------");
 							List<CustomerBusRoute> listBooking = customerService.getPreviousBookings(user.getUsername());
 							listBooking.stream().forEach(b->{
 								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
 								System.out.println("Booking Date: " + b.getDateOfBooking());
 								System.out.println("List of Passengers");
 								int i=1;
  								for(Passenger p : b.getPassenger()) {
 									System.out.println(i++ + ". " + p.getName() + "    " + p.getAge());
 								}
 								System.out.println("Bus Details: ");
 								System.out.println(b.getBusRoute().getBus());
 								System.out.println("Travel Details: ");
 								System.out.println(b.getBusRoute().getRoute());
 								System.out.println("Total Ticket Amount: " + b.getTotalAmount());
 								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
 							});
 							
  							break; 
 						case 2: 
 							break; 
 					}
					break; 
				case 3: 
					System.out.println("All Bus Info with routes");
					List<BusDto> listBusDto =  busService.getAllBusesWithRouteInfo();
					listBusDto.stream().forEach(e-> {
						System.out.println(e);
					}); 
					
					System.out.println("Enter the ID for Booking, Press 0 to go to main menu");
					int option = sc.nextInt();
					if(option == 0) {
						break; 
					}
					/* Login to Proceed with booking */
					user = new User();
					System.out.println("-----------CUSTOMER LOGIN-------------");
					System.out.println("Enter username/email");
					user.setUsername(sc.next());
					System.out.println("Enter password");
					user.setPassword(sc.next());
					
					if(userService.login(user) == false) {
						System.out.println("Invalid Credentials!!! Try again.. ");
						break; 
					};
					
					System.out.println("---------Enter Passenger Details-----------");
					System.out.println("How many passengers will be travelling?");
					int numPassenger = sc.nextInt();
					if(numPassenger < 1)
						break; 
					int i=1;
					List<Passenger> listPassenger = new ArrayList<>();
					while(i<=numPassenger) {
						Passenger passenger = new Passenger();
						//generate ID 
					
						System.out.println("Enter passenger name: ");
						passenger.setName(sc.next()); 
						System.out.println("Enter passenger age: ");
						passenger.setAge(sc.nextInt());
						listPassenger.add(passenger);
						i++;
					}
					CustomerBusRoute cbr =  customerService.processBooking(user,option,listPassenger); 
					System.out.println("*************Booking Details**************");
					System.out.println("Customer Name: " + cbr.getCustomer().getName());
					System.out.println("Number of Passengers: " + listPassenger.size());
					 
					System.out.println("--------Passenger Details-------");
					int x=1;
					for(Passenger p  : listPassenger) {
						System.out.println(x++ + ". " + p.getName() + "    " + p.getAge());
					}
					System.out.println("-------------------------------");
					 
					System.out.println("----------Booking Info---------");
					System.out.println("Bus Details: ");
					System.out.println(cbr.getBusRoute().getBus());
					System.out.println("Travel Details");
					System.out.println(cbr.getBusRoute().getRoute());
					System.out.println("--------------------------------");
					System.out.println("Booking Status: " + cbr.isConfirmed());
					System.out.println("*******************************************");
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