package com.springframework.myspringapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springframework.myspringapp.model.Product;
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
		List<Product> list = mainService.getAllProduct();
		model.addAttribute("pList", list);
		return "products";
	}
	
	@GetMapping("/delete-product")
	public String deleteProduct(HttpServletRequest request) {
		int pid = Integer.parseInt(request.getParameter("id"));
		List<Product> list = mainService.getAllProduct();
		List<Product> filteredList = mainService.filterProductList(list,pid);
		request.setAttribute("pList", filteredList);
		return "products";
	}
	
}
