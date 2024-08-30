package com.main.behavior;

public abstract class LoanHandler {

	 LoanHandler loanHandler; 
	
	public void forwardHandler(LoanHandler loanHandler){
		this.loanHandler = loanHandler;
	}
	
	public abstract void applyLoan(String acctNumber,double loanAmount);
}
