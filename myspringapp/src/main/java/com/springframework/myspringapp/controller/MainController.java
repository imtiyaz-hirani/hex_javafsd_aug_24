package com.springframework.myspringapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springframework.myspringapp.exception.DBOperationFailedException;
import com.springframework.myspringapp.model.Category;
import com.springframework.myspringapp.model.Product;
import com.springframework.myspringapp.model.Vendor;
import com.springframework.myspringapp.service.MainService;

import jakarta.servlet.http.HttpServletRequest;

@Controller //<-- this tells spring that it is a controller
public class MainController {
	
	@Autowired  //<- this object will be managed by Spring 
	private MainService mainService;
	
	@GetMapping("/hello")
	public String showHome(Model model) {
		model.addAttribute("msg",  mainService.getMessage());
		List<Integer> intList = Arrays.asList(1,4,2,6,7); 
		model.addAttribute("intList", intList);
		return "home";
	}
	
	
	@GetMapping("/all-products")
	public String allProducts(Model model) {
		List<Product> list = mainService.getAllProduct("active");
		List<Product> archivedList = mainService.getAllProduct("inactive");
		
		model.addAttribute("archivedList", archivedList);
		model.addAttribute("pList", list);
		return "products";
	}
	
	@GetMapping("/delete-product")
	public String deleteProduct(HttpServletRequest request, Model model) {
		int pid = Integer.parseInt(request.getParameter("id"));
		/*
		List<Product> list = mainService.getAllProduct();
		List<Product> filteredList = mainService.filterProductList(list,pid);
		*/
		try {
			mainService.updateProduct(pid,"inactive"); //soft delete 
			request.setAttribute("msg", "Product deleted from DB"); 
		} catch (DBOperationFailedException e) {
			request.setAttribute("msg", e.getMessage()); 
		}
		
		List<Product> list = mainService.getAllProduct("active");
		List<Product> archivedList = mainService.getAllProduct("inactive");
		
		model.addAttribute("archivedList", archivedList);
		model.addAttribute("pList", list);
		return "products";
	}
	
	@GetMapping("/show-add-product")
	public String showAddProduct(Model model) {
		//take list_category, list_vendor
		List<Category> catList = mainService.getAllCategory();
		List<Vendor> vendorlist = mainService.getAllVendors();
		model.addAttribute("catList", catList);
		model.addAttribute("vendorlist", vendorlist);
		return "add_product";
	}
	
	@PostMapping("/add-product")
	public String addProduct(HttpServletRequest request, Model model) { 
		String name=request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		double discount = Double.parseDouble(request.getParameter("discount"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int catId = Integer.parseInt(request.getParameter("catId"));
		int vendorId = Integer.parseInt(request.getParameter("vendorId"));
	//	System.out.println(name + "--" + price + "--" + discount+ "--" +qty+ "--" +catId + "--" +vendorId );
	
		try {
			mainService.addProduct(name,price,discount,qty,catId,vendorId);
			model.addAttribute("msg", "Product added to DB"); 
		} catch (DBOperationFailedException e) {
			model.addAttribute("msg", e.getMessage()); 
		}
		
		List<Category> catList = mainService.getAllCategory();
		List<Vendor> vendorlist = mainService.getAllVendors();
		model.addAttribute("catList", catList);
		model.addAttribute("vendorlist", vendorlist);
		
		return "add_product";
	}
	@GetMapping("/restore-product")
	public String restoreProduct(HttpServletRequest request, Model model) {
		int pid = Integer.parseInt(request.getParameter("id"));
		try {
			mainService.updateProduct(pid,"active");
		
		} catch (DBOperationFailedException e) {
			 
		}
		List<Product> list = mainService.getAllProduct("active");
		List<Product> archivedList = mainService.getAllProduct("inactive");
		
		model.addAttribute("archivedList", archivedList);
		model.addAttribute("pList", list);
		return "products";
	}
	
}
