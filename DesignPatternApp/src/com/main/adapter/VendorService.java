package com.main.adapter;

public class VendorService {

	public void confirmMobile(String mobileNumber) {
		
		SMSUtility.getInstance().sendSMS(SMSAdapter.adapt(mobileNumber));
	}
}
