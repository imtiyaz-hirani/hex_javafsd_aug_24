package com.springboot.my_boot_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my_boot_app.exception.InputValidationException;
import com.springboot.my_boot_app.exception.InvalidIdException;
import com.springboot.my_boot_app.model.Manager;
import com.springboot.my_boot_app.model.Project;
import com.springboot.my_boot_app.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ManagerService managerService;
	
	public Project addProject(int managerId, Project project) throws InputValidationException {
		 //fetch manager on the basis of managerId
		Manager manager =  managerService.getById(managerId);
		//attach manager to project
		project.setManager(manager);
		//save project
		return projectRepository.save(project); 
		
		
	}

	public Project getById(int pid) throws InvalidIdException {
		Optional<Project> optional =   projectRepository.findById(pid);
		if(optional.isEmpty())
			throw new InvalidIdException("project ID Invalid..");
		
		return optional.get();
	}

	public List<Project> getProjectByEmployeeId(int eid) {
		 
		return projectRepository.getProjectByEmployeeId(eid);
	}
}
