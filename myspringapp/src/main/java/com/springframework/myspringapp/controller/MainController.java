package com.springframework.myspringapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springframework.myspringapp.service.MainService;

@Controller //<-- this tells spring that it is a controller
public class MainController {
	
	@Autowired  //<- this object will be managed by Spring 
	private MainService mainService;
	
	@GetMapping("/hello")
	public String showHome(Model model) {
		model.addAttribute("msg",  mainService.getMessage());
		List<Integer> intList = Arrays.asList(1,4,2,6,7); 
		model.addAttribute("intList", intList);
		return "home";
	}
	
}
