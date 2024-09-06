package com.hibernate.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Passenger {

	@Id
	private int id;
	
	private String name; 
	
	private int age; 
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private BusRoute busRoute; 

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BusRoute getBusRoute() {
		return busRoute;
	}

	public void setBusRoute(BusRoute busRoute) {
		this.busRoute = busRoute;
	} 
	
	
}
