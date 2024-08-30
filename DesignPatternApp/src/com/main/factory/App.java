package com.main.factory;

public class App {

	public static void main(String[] args) {
		AccountFactory factory = new AccounttFactoryV1();
		Account account = factory.getAccount(AccountType.SAVINGS);
		System.out.println(account.getAccountDetails());
		
		account = factory.getAccount(AccountType.CURRENT);
		System.out.println(account.getAccountDetails());
	}

}
