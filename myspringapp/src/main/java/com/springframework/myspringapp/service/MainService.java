package com.springframework.myspringapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springframework.myspringapp.exception.DBOperationFailedException;
import com.springframework.myspringapp.model.Category;
import com.springframework.myspringapp.model.Product;
import com.springframework.myspringapp.model.Vendor;
import com.springframework.myspringapp.repository.CategoryRepository;
import com.springframework.myspringapp.repository.ProductRepository;
import com.springframework.myspringapp.repository.VendorRepository;

@Service //this registers the class as a bean in spring
public class MainService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private VendorRepository vendorRepository;
	
	public String getMessage() {
		System.out.println(productRepository.getAllProductTitle());
		return "hello user!!!";
	}

	public List<String> getProductTitle() {
		return productRepository.getAllProductTitle(); 
	}
	
	public List<Product> getAllProduct(String status) {
		
		return productRepository.getAllProducts(status);
	}

	public List<Product> filterProductList(List<Product> list, int pid) {
		return list.stream().filter(p->p.getId() != pid).toList(); 
		
	}

	public List<Category> getAllCategory() {
		 
		return categoryRepository.getAllCategory();
	}

	public List<Vendor> getAllVendors() {
		 
		return vendorRepository.getAllVendors();
	}

	public void addProduct(String name, double price, double discount, int qty, int catId, int vendorId) throws DBOperationFailedException {
		productRepository.addProduct(name,price,discount,qty,catId,vendorId);
		
	}

	public void updateProduct(int pid,String status) throws DBOperationFailedException {
		productRepository.updateProduct(pid, status);
		
	}
	
	/*Testing purpose */
	public int sum(int num1,int num2) {
		return num1+num2; 
	}
}










