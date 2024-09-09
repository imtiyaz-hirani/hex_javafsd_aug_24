package com.springboot.my_boot_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my_boot_app.EmployeeService;
import com.springboot.my_boot_app.model.Employee;

@RestController //@Controller + @ResponseBody: JSON 
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	/*
	 * PATH: http://localhost:port/employee/add
	 * */
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) { //reading the i/p
		return employeeService.addEmployee(employee);
	}
}


/*
@GetMapping 
@PostMapping : insert 
@DeleteMapping 
@PutMapping / @PostMapping 
*/