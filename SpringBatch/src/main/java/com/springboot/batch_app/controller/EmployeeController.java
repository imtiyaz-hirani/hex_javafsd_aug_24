package com.springboot.batch_app.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EmployeeController {

	@PostMapping("/employee/data/upload")
	public void uploadEmployeeDataCSV(@RequestBody MultipartFile file) {
		try {
			System.out.println("File " + file.getOriginalFilename() + " uploaded " + " with size " + file.getBytes());
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
	}
}
