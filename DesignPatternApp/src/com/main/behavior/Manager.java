package com.main.behavior;

public class Manager extends LoanHandler{

	 @Override
	public void applyLoan(String acctNumber, double loanAmount) {
		 if(loanAmount > 1000000) 
			 System.out.println("Beyond personal loan limit of 10 lakhs");
		 else
			 System.out.println("processed by manager");
		
	}

}
