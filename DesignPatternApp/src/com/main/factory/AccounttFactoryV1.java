package com.main.factory;

public class AccounttFactoryV1 extends AccountFactory{
 
	public Account getAccount(AccountType type) {
		if(type.equals(AccountType.SAVINGS))
			return new SavingAccount(); 
		if(type.equals(AccountType.CURRENT))
			return new CurrentAccount(); 
		
		return null;
	}
	
}
