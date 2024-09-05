package com.hibernate.main.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity //<-- create the table in DB 
public class Customer {

	@Id //this makes id a Primary key 
	private int id; 
	
	private String name; 
	
	private String contact; 
	
	private LocalDate dateOfSignUp = LocalDate.now();
	
	@OneToOne
	private User user; //user_id will be created as Foreign Key in customer table

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	} 
	
	
}
