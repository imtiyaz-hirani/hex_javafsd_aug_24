package com.springboot.my_boot_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.my_boot_app.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
