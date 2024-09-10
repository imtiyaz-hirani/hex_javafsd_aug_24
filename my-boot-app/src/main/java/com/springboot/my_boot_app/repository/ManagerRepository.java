package com.springboot.my_boot_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.my_boot_app.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>{

}
