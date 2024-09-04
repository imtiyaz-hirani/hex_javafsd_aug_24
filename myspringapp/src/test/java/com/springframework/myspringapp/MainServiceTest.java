package com.springframework.myspringapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}




