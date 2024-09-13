package com.asset.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset.model.InPatient;

public interface InPatientRepo extends JpaRepository<InPatient, Integer>{

}
