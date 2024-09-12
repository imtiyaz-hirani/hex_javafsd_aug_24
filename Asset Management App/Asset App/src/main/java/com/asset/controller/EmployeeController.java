package com.asset.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asset.exception.InvalidIdException;
import com.asset.model.Employee;
import com.asset.model.EmployeeAsset;
import com.asset.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PostMapping("/asset/request/{assetId}")
	public ResponseEntity<?> requestAsset(@PathVariable int assetId,  Principal principal) {
		String empUsername = principal.getName();//logged in employee
		try {
			EmployeeAsset empAsset =  employeeService.requestAsset(empUsername, assetId);
			return ResponseEntity.ok(empAsset);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
}
