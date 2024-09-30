package com.asset.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asset.model.DoctorSchedule;

public interface DoctorScheduleRepo extends JpaRepository<DoctorSchedule, Integer>{

	@Query("select ds from DoctorSchedule ds where ds.date=?1 AND ds.fromTime = ?2 AND ds.toTime=?3")
	DoctorSchedule getNumberOfAppointmentCount(LocalDate dateOfAppointment, LocalTime fromTime, LocalTime toTime);

	@Query("select ds from DoctorSchedule ds join ds.doctor d where d.user.username=?1")
	List<DoctorSchedule> getByUsername(String username);

}
