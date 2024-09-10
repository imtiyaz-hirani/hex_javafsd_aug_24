package com.springboot.my_boot_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my_boot_app.dto.MessageDto;
import com.springboot.my_boot_app.exception.InvalidIdException;
import com.springboot.my_boot_app.model.EmployeeProject;
import com.springboot.my_boot_app.service.EmployeeProjectService;

@RestController
public class EmployeeprojectController {

	@Autowired
	private EmployeeProjectService employeeProjectService;
	
	@PostMapping("/employee/project/add/{eid}/{pid}")
	public ResponseEntity<?> assignProjectToEmployee(@PathVariable int eid, 
										@PathVariable int pid, 
										@RequestBody EmployeeProject employeeProject,
										MessageDto dto) {
		try {
			employeeProject = employeeProjectService.assignProjectToEmployee(eid,pid,employeeProject);
			return ResponseEntity.ok(employeeProject); 
		} catch (InvalidIdException e) {
			dto.setMsg(e.getMessage());
			 return ResponseEntity.badRequest().body(dto); 
		}
	}
}
