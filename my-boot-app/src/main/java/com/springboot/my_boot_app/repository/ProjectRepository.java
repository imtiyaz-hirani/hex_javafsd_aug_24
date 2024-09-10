package com.springboot.my_boot_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.my_boot_app.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

	@Query("select p from EmployeeProject ep JOIN ep.employee e JOIN ep.project p where e.id=?1")
	List<Project> getProjectByEmployeeId(int eid);

	@Query(nativeQuery = true, value="select p.project_type as Project_Type, count(e.id) as Number_of_Employee "
			+ " from employee e JOIN employee_project ep ON e.id = ep.employee_id "
			+ " JOIN project p ON p.id = ep.project_id "
			+ " group by p.project_type")
	List<Object[]> getEmployeeCountByProjectType();
	
	@Query("select p.projectType, count(e.id)"
			+ " from EmployeeProject ep "
			+ " JOIN ep.employee e "
			+ " JOIN ep.project p "
			+ " group by p.projectType")
	List<Object[]> getEmployeeCountByProjectTypeJPQL();

}
