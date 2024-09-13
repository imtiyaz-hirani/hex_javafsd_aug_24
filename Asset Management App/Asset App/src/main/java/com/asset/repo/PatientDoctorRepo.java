package com.asset.repo;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.asset.model.PatientDoctor;

public interface PatientDoctorRepo extends JpaRepository<PatientDoctor, Integer>{


}
