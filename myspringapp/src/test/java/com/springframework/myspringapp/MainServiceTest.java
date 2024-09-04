package com.springframework.myspringapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
