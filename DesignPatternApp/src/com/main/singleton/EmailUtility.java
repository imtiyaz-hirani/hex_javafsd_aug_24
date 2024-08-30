package com.main.singleton;

//Singleton Design Pattern 
public class EmailUtility { //send an Email 
	
	private static EmailUtility emailUtility; 
	private EmailUtility(){ //step 1: make constructor private
		 
	}
	
	static {
		emailUtility = new EmailUtility(); //in static mem : 10X 
	}
	
	public void sendEmail(String message ) {
		//logic code of email send
		System.out.println("Email sent successfully... " + message);
	}

	public static EmailUtility getInstance() {
		return emailUtility;
	}
	
	
}
/*
 * Why: For common classes like DBConnection,EmailUtility we must allow only single 
 * instance throughout the project
 * 
 * How: 
 * 1. make constructor private 
   2. create getInstanceMethod()and return static instance of class from here. 
   
   Why static: 
   1. static memory holds only single object of the class as it does not allow duplicates. 
 */