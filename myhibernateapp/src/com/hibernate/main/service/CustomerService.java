package com.hibernate.main.service;

import com.hibernate.main.model.Customer;
import com.hibernate.main.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

	 

}
