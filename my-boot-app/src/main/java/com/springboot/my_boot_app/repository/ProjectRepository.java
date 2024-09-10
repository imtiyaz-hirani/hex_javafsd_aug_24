package com.springboot.my_boot_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.my_boot_app.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

	@Query("select p from EmployeeProject ep JOIN ep.employee e JOIN ep.project p where e.id=?1")
	List<Project> getProjectByEmployeeId(int eid);

}
