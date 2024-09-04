package com.springframework.myspringapp;

 
 import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springframework.myspringapp.service.MainService;

@SpringBootTest //<-- this declares the class to be a test class which can have @test annotation 
class MyspringappApplicationTests {

	@Autowired
	private MainService mainService;
 
	@Test //<- makes the method to be a test case 
	void contextLoads() {
		int exectedVal = 5; 
		int actualVal = mainService.sum(3, 2); 
		assertEquals(exectedVal, actualVal);
	}

}
/*
 * JUnit 5: latest version 
 * Runner: Hamcrest 
 * 
 * Which class are you using to do testing: Assertion class. 
 *  - assertEquals 
 *  - assertNotNull
 *  - assertTrue
 *  etc... 
 */

/*
 * assertEquals(arg1,arg2)   
 * arg1: expected value : programmer's expections    
 * arg2: actual value - when the method is called, it is actual value   
 * 
 * if(expected == actual) : test will pass else fail 
 */