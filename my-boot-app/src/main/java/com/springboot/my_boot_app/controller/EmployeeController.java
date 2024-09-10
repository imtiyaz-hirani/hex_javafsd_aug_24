package com.springboot.my_boot_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my_boot_app.dto.MessageDto;
import com.springboot.my_boot_app.exception.InputValidationException;
import com.springboot.my_boot_app.exception.InvalidIdException;
import com.springboot.my_boot_app.model.Employee;
import com.springboot.my_boot_app.service.EmployeeService;

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
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee, MessageDto dto) { //reading the i/p
		
		try {
			employeeService.validate(employee);
		} catch (InputValidationException e) {
			dto.setMsg(e.getMessage());
			 return ResponseEntity.badRequest().body(dto); 
		} 
		
		
		return ResponseEntity.ok(employeeService.addEmployee(employee)); 
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
	
	/*
	 * PATH: http://localhost:port/employee/one
	 * method: DELETE 
	 * Description: delete single employee on the basis of given ID 
	 * @Param: eid
	 * @return: String 
	 * @throws: InvalidIdException 
	 * */
	
	@DeleteMapping("/one/{eid}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int eid,MessageDto dto) {
		try {
			employeeService.deleteEmployee(eid);
			dto.setMsg("Employee Deleted..");
			return ResponseEntity.ok(dto);
		} catch (InvalidIdException e) {
			dto.setMsg(e.getMessage());
			 return ResponseEntity.badRequest().body(dto);
		} 
	}
	
	/*
	 * PATH: http://localhost:port/employee/update
	 * method: PUT/POST 
	 * Description: update single employee on the basis of given ID and new employee data 
	 * @Param: eid , new Employee obj 
	 * @return: Employee 
	 * @throws: InvalidIdException 
	 * */
	
	@PutMapping("/update/{eid}")
	public ResponseEntity<?> updateEmployee(@PathVariable int eid,@RequestBody Employee newEmployee, MessageDto dto) {
		try {
			Employee emp = employeeService.updateEmployee(eid,newEmployee);
			return ResponseEntity.ok(emp); 
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