package com.main.singleton;

public class ProductService {

	public void addProduct() {
		System.out.println("Product added..");
		//EmailUtility emailUtility = new EmailUtility();
		EmailUtility.getInstance().sendEmail("hey vendor, product is added to your account"); 
	}
}
