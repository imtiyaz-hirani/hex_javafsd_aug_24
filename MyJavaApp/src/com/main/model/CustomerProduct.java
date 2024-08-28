package com.main.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CustomerProduct {

	private Customer customer;
	private Product product;
	private LocalDate dateOfPurchase;
	private LocalTime timeOfPurchase;
	private int qty;
	private double totalAmount;

	public CustomerProduct(Customer customer, Product product, LocalDate dateOfPurchase, LocalTime timeOfPurchase,
			int qty, double totalAmount) {
		super();
		this.customer = customer;
		this.product = product;
		this.dateOfPurchase = dateOfPurchase;
		this.timeOfPurchase = timeOfPurchase;
		this.qty = qty;
		this.totalAmount = totalAmount;
	}

	public CustomerProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public LocalTime getTimeOfPurchase() {
		return timeOfPurchase;
	}

	public void setTimeOfPurchase(LocalTime timeOfPurchase) {
		this.timeOfPurchase = timeOfPurchase;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "CustomerProduct [customer=" + customer + ", product=" + product + ", dateOfPurchase=" + dateOfPurchase
				+ ", timeOfPurchase=" + timeOfPurchase + ", qty=" + qty + ", totalAmount=" + totalAmount + "]";
	}

}
