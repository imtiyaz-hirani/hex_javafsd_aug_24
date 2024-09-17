package com.springboot.batch_app.controller;

 
 import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.batch_app.model.Employee;
import com.springboot.batch_app.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee/data/upload")
	public ResponseEntity<?> uploadEmployeeDataCSV(@RequestBody MultipartFile file) { //handler
		try {
			employeeService.insertEmployeeDataCSV(file);
			return ResponseEntity.ok("Employee data uploaded and added to DB");
		} catch (IOException e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@GetMapping("/employee/all")
	public List<Employee> getAllEmployee(){
		return employeeService.getAll();
	}
}
