package com.main.exception;

public class InvalidIdException extends Exception{  
	 
	private static final long serialVersionUID = 8206616436067974675L;
 
	private String message;

	public InvalidIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	} 
	
	
}
