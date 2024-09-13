package com.asset.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset.model.DoctorSchedule;

public interface DoctorScheduleRepo extends JpaRepository<DoctorSchedule, Integer>{

}
