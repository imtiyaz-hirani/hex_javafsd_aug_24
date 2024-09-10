package com.springboot.my_boot_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my_boot_app.dto.MessageDto;
import com.springboot.my_boot_app.exception.InputValidationException;
import com.springboot.my_boot_app.model.Manager;
import com.springboot.my_boot_app.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	/*
	 * PATH: http://localhost:port/manager/add
	 * method: POST
	 * Description: Add manager to DB 
	 * @Param: Manager 
	 * @return: Manager 
	 * */
	@PostMapping("/add")
	public ResponseEntity<?> addManager(@RequestBody Manager manager, MessageDto dto) { //reading the i/p
		 
		return ResponseEntity.ok(managerService.addManager(manager)); 
	}
	
}
