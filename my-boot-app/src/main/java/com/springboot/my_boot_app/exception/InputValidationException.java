package com.springboot.my_boot_app.exception;

public class InputValidationException extends Exception{
 
	private static final long serialVersionUID = 1L;
	
	private String message;

	public InputValidationException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	} 
	
	
}
