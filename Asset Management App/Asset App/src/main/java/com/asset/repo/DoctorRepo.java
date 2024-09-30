package com.asset.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asset.model.Doctor;
import com.asset.model.DoctorSchedule;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

	@Query("select ds from DoctorSchedule ds where ds.doctor.id =?1")
	List<DoctorSchedule> getScheduleByDoctorId(int doctorId);

	@Query("select d from Doctor d where d.user.username=?1")
	Optional<Doctor> getByUsername(String name);

}
