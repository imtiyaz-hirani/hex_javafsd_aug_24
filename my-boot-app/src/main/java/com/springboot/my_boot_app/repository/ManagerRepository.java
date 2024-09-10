package com.springboot.my_boot_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.my_boot_app.model.Employee;
import com.springboot.my_boot_app.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>{

	@Query("select e from EmployeeProject ep "
			+ " JOIN ep.employee e "
			+ " JOIN ep.project p "
			+ " JOIN p.manager m "
			+ " JOIN m.user u "
			+ " where u.username=?1")
	List<Employee> getEmployeeByManagerUsername(String username);

}
