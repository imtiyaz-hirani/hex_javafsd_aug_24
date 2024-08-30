package com.main.behavior;

public class AssistantManager extends LoanHandler{ //Manager is AsstManager Loan Handler 

	 @Override
		public void applyLoan(String acctNumber, double loanAmount) {
		 if(loanAmount <=500000) {
				System.out.println("Loan processed by asst manager ");
			}
			else
				loanHandler.applyLoan(acctNumber,loanAmount);
			
		}

}
