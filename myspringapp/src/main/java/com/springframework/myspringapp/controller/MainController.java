package com.springframework.myspringapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //<-- this tells spring that it is a controller
public class MainController {

	@GetMapping("/hello")
	public String showHome() {
	return "home";
	}
	
}
