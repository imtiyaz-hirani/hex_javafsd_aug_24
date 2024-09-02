package com.springframework.myspringapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springframework.myspringapp.model.Product;

@Service //this registers the class as a bean in spring
public class MainService {

	public String getMessage() {
		return "hello user!!!";
	}

	public List<Product> getAllProduct() {
		Product p1 = new Product(1,"Apple Iphone", 67000, 3000, 5);
		Product p2 = new Product(2,"Oppo A13", 27000, 2000, 7);
		Product p3 = new Product(3,"OnePlus Nord 3", 37000, 4500, 5);
		
		List<Product> list = Arrays.asList(p1,p2,p3);
		
		return list;
	}

	public List<Product> filterProductList(List<Product> list, int pid) {
		return list.stream().filter(p->p.getId() != pid).toList(); 
		
	}
	
}
