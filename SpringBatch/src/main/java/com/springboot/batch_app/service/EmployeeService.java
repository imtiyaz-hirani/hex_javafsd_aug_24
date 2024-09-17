package com.springboot.batch_app.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.batch_app.model.Employee;
import com.springboot.batch_app.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo; 
	
	public void insertEmployeeDataCSV(MultipartFile file) throws IOException {
		 
			InputStream inputStream =  file.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)); 
			bufferedReader.readLine(); //this gives us headings and we ignore them 
			String data = "";
			List<Employee> list = new ArrayList<>(); 
			
			while( (data = bufferedReader.readLine()) != null) {
				Employee employee 
						= new Employee(data.split(",")[0],
									   data.split(",")[1],
									   Double.parseDouble(data.split(",")[2]),
									   data.split(",")[3]); 
				list.add(employee);
			}
			
			/*Save this list using spring batch */
			employeeRepo.saveAll(list);
		}

	public List<Employee> getAll() {
		 
		return employeeRepo.findAll();
	}

}
