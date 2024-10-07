package com.asset.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.asset.model.Product;
import com.asset.model.ProductImage;
import com.asset.service.ProductService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/add")
	public Product addProduct(@RequestBody Product product) {
		return productService.add(product);
	}
	
	@PostMapping("/product/image/upload/{pid}")
	public void addProductImage(@PathVariable int pid, 
			@RequestParam MultipartFile file) {
		
		/*Fetch product */
		Product product = productService.getById(pid);
		
		String location = "D:/hex-fsd-aug-24/revised-angular-app/public/images/";
		//System.out.println(file.getOriginalFilename()); //Screenshot 2024-06-22 004128.png
		//System.out.println(file.getName());
		
		ProductImage pi = new ProductImage();
		
		try {
			Files.copy(file.getInputStream(), Path.of(location, file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			pi.setName(file.getOriginalFilename());
			pi.setPath(Path.of(location, file.getOriginalFilename()).toString());
			pi.setProduct(product);
			productService.save(pi); 
			
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
	}
}
