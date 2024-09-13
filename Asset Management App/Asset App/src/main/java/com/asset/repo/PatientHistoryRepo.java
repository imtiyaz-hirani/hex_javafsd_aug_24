package com.asset.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset.model.PatientHistory;

public interface PatientHistoryRepo extends JpaRepository<PatientHistory, Integer>{

}
