package com.springboot.my_boot_app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my_boot_app.exception.InvalidIdException;
import com.springboot.my_boot_app.model.Employee;
import com.springboot.my_boot_app.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public Employee getById(int eid) throws InvalidIdException {
		Optional<Employee> optional =  employeeRepository.findById(eid);
		if(optional.isEmpty())
			throw new InvalidIdException("Invalid ID Given"); 
		return optional.get();
	}

	public void deleteEmployee(int eid) throws InvalidIdException {
		Optional<Employee> optional =  employeeRepository.findById(eid);
		if(optional.isEmpty())
			throw new InvalidIdException("Invalid ID Given"); 
		
		employeeRepository.deleteById(eid);
		
	}

}
