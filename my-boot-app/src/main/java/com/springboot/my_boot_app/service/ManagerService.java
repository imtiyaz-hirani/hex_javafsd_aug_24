package com.springboot.my_boot_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my_boot_app.enums.RoleType;
import com.springboot.my_boot_app.exception.InputValidationException;
import com.springboot.my_boot_app.model.Employee;
import com.springboot.my_boot_app.model.Manager;
import com.springboot.my_boot_app.model.User;
import com.springboot.my_boot_app.repository.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private UserService userService;
	
	public Object addManager(Manager manager) {
		//extract user details from manager and save it in DB so that hibernate can add id to this 
		User user = manager.getUser();
		user.setRole(RoleType.MANAGER);
		user = userService.adduser(user);
		 
		//attach this user , fully formed object to employee
		manager.setUser(user);
		 
		return managerRepository.save(manager);
	}

	public Manager getById(int managerId) throws InputValidationException {
		 Optional<Manager> optional =  managerRepository.findById(managerId);
		 if(optional.isEmpty())
			 throw new InputValidationException("Manager ID Invalid");
		
		 return optional.get();
	}

	public List<Employee> getEmployeeByManagerUsername(String username) {
		 
		return managerRepository.getEmployeeByManagerUsername(username);
	}
}









