package com.springboot.batch_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.batch_app.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
