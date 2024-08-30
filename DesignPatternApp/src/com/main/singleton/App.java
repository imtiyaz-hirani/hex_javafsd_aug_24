package com.main.singleton;

public class App {

	public static void main(String[] args) {
		 CustomerService customerService = new CustomerService();
		 ProductService productService = new ProductService();
		 customerService.register();
		 productService.addProduct();

	}

}
