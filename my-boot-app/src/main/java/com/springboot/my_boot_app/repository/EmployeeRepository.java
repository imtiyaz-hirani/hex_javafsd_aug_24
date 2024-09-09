package com.springboot.my_boot_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.my_boot_app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{


}
//save(employeeObj): Employee 
//findAll(): List<Employee>
//findById(id): Employee
//deleteById(id): void