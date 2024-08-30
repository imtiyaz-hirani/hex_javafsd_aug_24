package com.main.adapter;

public class SMSAdapter {

	public static String adapt(String mobileNumber) {
		if(mobileNumber.length() > 10) {
			mobileNumber = mobileNumber.substring(mobileNumber.length() - 10,mobileNumber.length());
  		}
		return mobileNumber; 
	}
}
