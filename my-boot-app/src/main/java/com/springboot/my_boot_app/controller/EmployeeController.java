package com.springboot.my_boot_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my_boot_app.EmployeeService;
import com.springboot.my_boot_app.dto.MessageDto;
import com.springboot.my_boot_app.exception.InvalidIdException;
import com.springboot.my_boot_app.model.Employee;

@RestController //@Controller + @ResponseBody: JSON 
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	/*
	 * PATH: http://localhost:port/employee/add
	 * method: POST
	 * Description: Add customer to DB 
	 * @Param: Employee employee
	 * @return: Employee 
	 * */
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) { //reading the i/p
		return employeeService.addEmployee(employee);
	}
	
	/*
	 * PATH: http://localhost:port/employee/all
	 * method: GET 
	 * Description: fetch all customers 
	 * @Param: ----
	 * @return: List<Employee> 
	 * */
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	
	/*
	 * PATH: http://localhost:port/employee/one
	 * method: GET 
	 * Description: fetch single employee on the basis of given ID 
	 * @Param: eid
	 * @return: Employee 
	 * @throws: InvalidIdException 
	 * */
	
	@GetMapping("/one/{eid}")
	public ResponseEntity<?> getById(@PathVariable int eid, MessageDto dto) {
		try {
			 Employee employee = employeeService.getById(eid);
			 return ResponseEntity.ok(employee); 
			 
		} catch (InvalidIdException e) {
			dto.setMsg(e.getMessage()); 
			return ResponseEntity.badRequest().body(dto);
		}
	}
	
}

/*  	  Object 
 * Employee 	String
 * */


/*
@GetMapping 
@PostMapping : insert 
@DeleteMapping 
@PutMapping / @PostMapping 
*/