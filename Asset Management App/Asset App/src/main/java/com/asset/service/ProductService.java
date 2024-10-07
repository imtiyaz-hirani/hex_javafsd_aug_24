package com.asset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asset.model.Product;
import com.asset.model.ProductImage;
import com.asset.repo.ProductImageRepo;
import com.asset.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ProductImageRepo productImageRepo;
	public Product add(Product product) {
		 
		return productRepo.save(product);
	}

	public void save(ProductImage pi) {
		productImageRepo.save(pi);
		
	}

	public Product getById(int pid) {
		 
		return productRepo.findById(pid).get();
	}

}
