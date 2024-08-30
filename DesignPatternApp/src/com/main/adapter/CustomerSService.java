package com.main.adapter;

public class CustomerSService {

	public void confirmContact(String mobileNumber) {
		SMSUtility.getInstance().sendSMS(SMSAdapter.adapt(mobileNumber));
	}
}
