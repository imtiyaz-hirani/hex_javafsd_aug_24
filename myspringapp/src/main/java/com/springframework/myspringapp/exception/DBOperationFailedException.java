package com.springframework.myspringapp.exception;

public class DBOperationFailedException extends Exception{
 
	private static final long serialVersionUID = 1L;
	private String message;

	public DBOperationFailedException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
	
	
}
