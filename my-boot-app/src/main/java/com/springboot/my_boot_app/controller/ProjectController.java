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

import com.springboot.my_boot_app.dto.MessageDto;
import com.springboot.my_boot_app.exception.InputValidationException;
import com.springboot.my_boot_app.model.Project;
import com.springboot.my_boot_app.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/add/{managerId}")
	public ResponseEntity<?> addProject(@PathVariable int managerId, @RequestBody Project project, MessageDto dto) {
		try {
			project =  projectService.addProject(managerId, project);
			return ResponseEntity.ok(project);
		} catch (InputValidationException e) {
			 dto.setMsg(e.getMessage());
			 return ResponseEntity.badRequest().body(dto);
		}
	}
	
	@GetMapping("/employee/{eid}")
	public List<Project> getProjectByEmployeeId(@PathVariable int eid) {
		return projectService.getProjectByEmployeeId(eid);
	}
}
