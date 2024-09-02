package com.springframework.myspringapp.service;

import org.springframework.stereotype.Service;

@Service //this registers the class as a bean in spring
public class MainService {

	public String getMessage() {
		return "hello user!!!";
	}
	
}
