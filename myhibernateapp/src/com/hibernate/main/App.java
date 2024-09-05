package com.hibernate.main;

import java.util.Scanner;

import org.hibernate.SessionFactory;

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
		
		while(true) {
			System.out.println("--------------Main Menu: ECOM--------------");
			System.out.println("1. Insert");
			System.out.println("0. Exit");
			int input = sc.nextInt();
			if(input == 0 ) {
				System.out.println("Exiting, thank you!!!");
				break; //breaks the while loop 
			}
			
			switch(input) {
				case 1: 
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