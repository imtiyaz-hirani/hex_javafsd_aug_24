package com.main.dto;

import java.time.LocalDate;

public class ProductDto {
	private String title;
	private double price;
	private LocalDate dateOfPurchase;
	private String vendorName; 
	
	 

	public ProductDto(String title, double price, LocalDate dateOfPurchase, String vendorName) {
		super();
		this.title = title;
		this.price = price;
		this.dateOfPurchase = dateOfPurchase;
		this.vendorName = vendorName;
	}

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Override
	public String toString() {
		return "ProductDto [title=" + title + ", price=" + price + ", dateOfPurchase=" + dateOfPurchase
				+ ", vendorName=" + vendorName + "]";
	}
 

}
