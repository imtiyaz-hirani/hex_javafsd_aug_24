package com.main.singleton;

public class CustomerService {

	
	public void register() {
		//logic 
		System.out.println("registration done.. ");
	//	EmailUtility emailUtility = new EmailUtility(); //i stop this 
		EmailUtility.getInstance().sendEmail("Hicustomer You are registered..");
		
	}
}
