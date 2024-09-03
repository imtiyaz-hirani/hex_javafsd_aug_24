package com.springframework.myspringapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springframework.myspringapp.model.Category;
import com.springframework.myspringapp.model.Product;
import com.springframework.myspringapp.repository.CategoryRepository;
import com.springframework.myspringapp.repository.ProductRepository;

@Service //this registers the class as a bean in spring
public class MainService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	public String getMessage() {
		System.out.println(productRepository.getAllProductTitle());
		return "hello user!!!";
	}

	public List<Product> getAllProduct() {
		
		return productRepository.getAllProducts();
	}

	public List<Product> filterProductList(List<Product> list, int pid) {
		return list.stream().filter(p->p.getId() != pid).toList(); 
		
	}

	public List<Category> getAllCategory() {
		 
		return categoryRepository.getAllCategory();
	}
	
}
