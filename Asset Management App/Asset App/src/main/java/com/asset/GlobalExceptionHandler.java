package com.asset;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler {
 
	//@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handleInvalidIdException(Exception e ) {
		return ResponseEntity.badRequest().body("No such resource found: " + e.getMessage()); 
	}
}
