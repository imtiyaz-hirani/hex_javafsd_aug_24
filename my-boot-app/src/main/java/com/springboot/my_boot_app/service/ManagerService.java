package com.springboot.my_boot_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my_boot_app.enums.RoleType;
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
}
