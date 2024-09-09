package com.springboot.my_boot_app.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my_boot_app.exception.InputValidationException;
import com.springboot.my_boot_app.exception.InvalidIdException;
import com.springboot.my_boot_app.model.Employee;
import com.springboot.my_boot_app.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	public Employee addEmployee(Employee employee) {
		logger.info("adding employee to DB " + employee);
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployee() {
		logger.info("Fetching all employees from DB..");
		return employeeRepository.findAll();
	}

	public Employee getById(int eid) throws InvalidIdException {
		Optional<Employee> optional =  employeeRepository.findById(eid);
		if(optional.isEmpty()) {
			logger.error("Invalid ID Found in request, Exception thrown.. ");
			throw new InvalidIdException("Invalid ID Given"); 
		}
		logger.info("Employee Obj retrieved basis given ID");
		return optional.get();
	}

	public void deleteEmployee(int eid) throws InvalidIdException {
		Optional<Employee> optional =  employeeRepository.findById(eid);
		if(optional.isEmpty()) {
			logger.error("Invalid ID Found in request, Exception thrown.. ");
			throw new InvalidIdException("Invalid ID Given"); 
		}
		logger.info("Employee record deletion basis given ID");
		logger.warn("Hard delete of employee record");
		employeeRepository.deleteById(eid);
		
	}

	public Employee updateEmployee(int eid, Employee newEmployee) throws InvalidIdException {
		Optional<Employee> optional =  employeeRepository.findById(eid);
		if(optional.isEmpty())
			throw new InvalidIdException("Invalid ID Given"); 
		
		Employee employeeDB = optional.get(); //this has old values of name and contact 
		//transfer newEmployee records to employeeDB 
		employeeDB.setName(newEmployee.getName());
		employeeDB.setContact(newEmployee.getContact());
		
		//save this employeeDb again with updated value 
		return employeeRepository.save(employeeDB);
	}

	public void validate(Employee employee) throws InputValidationException {
		if(employee == null)  {
			logger.error("Employee given is NULL, InputValidationException Thrown");
			throw new InputValidationException("Object cannot be null ");
		}
		if(employee.getName() == null || employee.getName().equals(""))  {
			logger.error("Employee name given is NULL or blank, InputValidationException Thrown");
			throw new InputValidationException("Field employee.name cannot be blank ");
		}
		if(employee.getContact() == null || employee.getContact().equals(""))  {
			logger.error("Employee contact given is NULL or blank, InputValidationException Thrown");
			throw new InputValidationException("Field employee.contact cannot be blank ");
		}
	}

}
