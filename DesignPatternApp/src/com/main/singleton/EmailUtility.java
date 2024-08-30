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
