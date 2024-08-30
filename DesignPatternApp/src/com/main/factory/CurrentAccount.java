package com.main.factory;

public class CurrentAccount implements Account{


	private double rateOfInterest; 
	private double annualCharges; 
	
	
	public CurrentAccount() {
		super();
		this.rateOfInterest = 2.0;
		this.annualCharges = 1000;
	}


	@Override
	public String getAccountDetails() {
		 String details = "Account Details: ROI: Rs." + rateOfInterest + " Annual Charge Rs." + annualCharges; 
		return details;
	}


	public double getRateOfInterest() {
		return rateOfInterest;
	}


	public double getAnnualCharges() {
		return annualCharges;
	}
	
	
}
