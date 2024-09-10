package com.springboot.my_boot_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my_boot_app.exception.InvalidIdException;
import com.springboot.my_boot_app.model.Employee;
import com.springboot.my_boot_app.model.EmployeeProject;
import com.springboot.my_boot_app.model.Project;
import com.springboot.my_boot_app.repository.EmployeeProjectRepository;

@Service
public class EmployeeProjectService {

	@Autowired
	private EmployeeProjectRepository employeeProjectRepository;

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProjectService projectService;
	
	public EmployeeProject assignProjectToEmployee(int eid, int pid, EmployeeProject employeeProject) 
			throws InvalidIdException {
		Employee employee = employeeService.getById(eid);
		
		Project project = projectService.getById(pid);
		
		employeeProject.setEmployee(employee);
		employeeProject.setProject(project);
		
		return employeeProjectRepository.save(employeeProject);
	}
}
