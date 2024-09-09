package com.springboot.my_boot_app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my_boot_app.model.Employee;

@RestController //@Controller + @ResponseBody: JSON 
@RequestMapping("/employee")
public class EmployeeController {

	/*
	 * PATH: http://localhost:port/employee/add
	 * */
	@PostMapping("/add")
	public void addEmployee(@RequestBody Employee employee) { //reading the i/p
		System.out.println(employee.getName());
		System.out.println(employee.getContact());		
	}
}


/*
@GetMapping 
@PostMapping : insert 
@DeleteMapping 
@PutMapping / @PostMapping 
*/