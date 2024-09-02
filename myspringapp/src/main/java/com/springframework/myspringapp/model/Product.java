package com.springframework.myspringapp.model;

public class Product {
	private int id;
	private String title;
	private double price;
	private double discount;
	private int stockQuantity;

	public Product(int id, String title, double price, double discount, int stockQuantity) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.discount = discount;
		this.stockQuantity = stockQuantity;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", discount=" + discount
				+ ", stockQuantity=" + stockQuantity + "]";
	}

}
