package com.springframework.myspringapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springframework.myspringapp.model.Product;
import com.springframework.myspringapp.service.MainService;

@SpringBootTest
public class MainServiceTest {

	@Autowired
	private MainService mainService;
	
	@Test
	public void getProductTitleTest() {
		int exceptedNum = 7; 
		int actualNum = mainService.getProductTitle().size();
		assertEquals(exceptedNum, actualNum);
	}
	
	@Test
	public void getAllProductTest() {
		List<Product> listActive =  mainService.getAllProduct("active"); //use case 1 
		List<Product> listInActive =  mainService.getAllProduct("inactive"); //use case 2
		List<Product> listInvalid =  mainService.getAllProduct(""); //use case 3
		
		int expectedActive = 6; 
		int expectedInactive = 1;  
		int expectedInvalid = 0; 
		
		assertNotNull(listActive);
		assertNotNull(listInActive);
		assertNotNull(listInvalid);
		
		int actualActive = listActive.size();
		int actualInActive = listInActive.size();
		int actualInvalid = listInvalid.size();
		
		assertEquals(expectedActive, actualActive);
		assertEquals(expectedInactive, actualInActive);
		assertEquals(expectedInvalid, actualInvalid);
		
	}
	
	public void getAllCategoryTest() {
		
	}
	
	public void getAllVendorTest() {
		
	}
	
	@Test
	public void filterProductListTest() {
		Product p1 = new Product();
		p1.setId(1);
		p1.setTitle("title1");
		p1.setPrice(100);
		
		Product p2 = new Product();
		p2.setId(4);
		p2.setTitle("title2");
		p2.setPrice(120);
		
		Product p3 = new Product();
		p3.setId(2);
		p3.setTitle("title3");
		p3.setPrice(200);
		
		List<Product> list = Arrays.asList(p1,p2,p3);
		
		//Use Case 1: Valid ID 
		int expectedNum = 2; 
		List<Product> filteredList = mainService.filterProductList(list, 1); 
		
		assertNotNull(filteredList);
		assertEquals(expectedNum, filteredList.size());
		
		//Use Case 2: invalid ID 
		expectedNum = 3; 
		filteredList = mainService.filterProductList(list, 6); 
		assertNotNull(filteredList);
		assertEquals(expectedNum, filteredList.size());
		
		//Use Case 3: Comparing list elements(Object)
		filteredList = mainService.filterProductList(list, 2); 
		List<Product> expectedList = Arrays.asList(p1,p2);
		
		assertNotNull(filteredList);
		
		assertNotNull(expectedList);
		
		assertEquals(expectedList, filteredList);
		
	}
}




