package com.hibernate.main.service;

import java.util.List;

import com.hibernate.main.model.BusRoute;
import com.hibernate.main.model.Customer;
import com.hibernate.main.model.CustomerBusRoute;
import com.hibernate.main.model.Passenger;
import com.hibernate.main.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class CustomerService {

	private EntityManager entityManager;
	private EntityTransaction entityTransaction; 
	
	public CustomerService(EntityManager entityManager, EntityTransaction entityTransaction) {
		this.entityManager = entityManager;
		this.entityTransaction = entityTransaction;
	}

	public void addCustomer(Customer customer) throws Exception{
		 
		 //step 1: Start the transaction 
		entityTransaction.begin();
		
		//Step 2: Perform db ops 
		//generate id for User & Customer  
		int userId = (int)(Math.random()*1000000); 
		customer.getUser().setId(userId);
		int customerId = (int)(Math.random()*1000000); 
		customer.setId(customerId);
		
		entityManager.persist(customer.getUser()); //persist the user 
		entityManager.persist(customer); //persist the customer 
		
		//Step 3: commit the transaction
		entityTransaction.commit();
		 
	}

	public CustomerBusRoute processBooking(User user, int busRouteId, List<Passenger> listPassenger) {
		entityTransaction.begin();
		//from user fetch customer 
		String sql1 ="select c from Customer c JOIN c.user u where u.username=?1";
		Query query = entityManager.createQuery(sql1, Customer.class);
		query.setParameter(1, user.getUsername());
		Customer customer = (Customer) query.getSingleResult();
		//System.out.println(customer);
		
		//fetch BusRoute obj using busRouteId 
		BusRoute busRoute = entityManager.find(BusRoute.class, busRouteId);
		//System.out.println(busRoute);
		
		
		//insert passenger details 
		for(Passenger p : listPassenger) {
			int id = (int)(Math.random()*1000000); 
			p.setId(id);
			p.setCustomer(customer);
			p.setBusRoute(busRoute);
			entityManager.persist(p);
		}
		
		//insert booking into customer_busRoute
		double totalAmount = busRoute.getTicket() * listPassenger.size();
		CustomerBusRoute customerBusRoute = new CustomerBusRoute();
		//set id
		int id = (int)(Math.random()*1000000); 
		customerBusRoute.setId(id);
		customerBusRoute.setTotalAmount(totalAmount);
		customerBusRoute.setConfirmed(true);
		customerBusRoute.setCustomer(customer);
		customerBusRoute.setBusRoute(busRoute);
		
		entityManager.persist(customerBusRoute);
		entityTransaction.commit();
		return customerBusRoute; 
		
	}
	
	//insert/update/delete: persist 
	//select : createQuery(sql,Class)

}









