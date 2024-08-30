package com.main.behavior;

public class Executive extends LoanHandler{ // AssistantManager is executives loanHandler 

	 @Override
		public void applyLoan(String acctNumber, double loanAmount) {
			if(loanAmount <=200000) {
				System.out.println("Loan processed by executive ");
			}
			else
				loanHandler.applyLoan(acctNumber,loanAmount); //assiMan.loanHandler() 
			
		}

}
