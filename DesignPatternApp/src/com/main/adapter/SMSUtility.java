package com.main.adapter;

public class SMSUtility {

	private static SMSUtility smsUtility; 
	
	private SMSUtility() {
		super();
		// TODO Auto-generated constructor stub
	}

	static {
		smsUtility = new SMSUtility();
	}
	
	public static SMSUtility getInstance(){
		return smsUtility; 
	}
	
	public void sendSMS(String mobileNumber){
		//logic 
		System.out.println("SMS Sent to " + mobileNumber);
	}
}
