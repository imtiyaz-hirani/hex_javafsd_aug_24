package com.asset.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset.model.Medication;

public interface MedicationRepo extends JpaRepository<Medication, Integer>{

}
