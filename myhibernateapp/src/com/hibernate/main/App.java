package com.hibernate.main;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
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
		
		SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("ecomUnit");
		
		/*Set up EntityManager*/
		EntityManager entityManager = sessionFactory.createEntityManager();
		System.out.println(entityManager);
	}

}

/*
 * 
 * EntityManagerFactory
 *  	|
 *  SessionFactory 
 * 
 */