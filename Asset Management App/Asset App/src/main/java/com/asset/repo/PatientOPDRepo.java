package com.asset.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset.model.PatientOPD;

public interface PatientOPDRepo extends JpaRepository<PatientOPD, Integer>{

}
