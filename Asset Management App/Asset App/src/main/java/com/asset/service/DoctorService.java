package com.asset.service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.asset.exception.InvalidIdException;
import com.asset.model.Doctor;
import com.asset.model.DoctorSchedule;
import com.asset.model.UserInfo;
import com.asset.repo.DoctorRepo;
import com.asset.repo.DoctorScheduleRepo;
import com.asset.repo.UserRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepo doctorRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DoctorScheduleRepo doctorScheduleRepo;
	
	public Doctor addDcotor(Doctor doctor) {
		 /* extract UserInfo from doctor  */
		UserInfo info = doctor.getUser();
		
		/*Encrypt password and assign Role to doctor via UserInfo*/
		info.setPassword(passwordEncoder.encode(info.getPassword()));
		info.setRole("ROLE_DOCTOR");
		
		/* save UserInfo */
		info = userRepository.save(info); //fully prepared obj  with id, role and pass-encoded
		
		/* Attach Attach fully prepared UserInfo obj to Doctor*/
		doctor.setUser(info);
		
		/*Save Doctor */
		return doctorRepo.save(doctor);
	}

	public DoctorSchedule addDoctorSchedule(String username, DoctorSchedule doctorSchedule) throws InvalidIdException {
		/* fetch doctor basis doctorId  */
		Optional<Doctor> optional =  doctorRepo.getByUsername(username); 
		if(optional.isEmpty())
			throw new InvalidIdException("Doctor ID Invalid");
		
		Doctor doctor = optional.get();
		/* attach doctor to doctorSchedule */
		doctorSchedule.setDoctor(doctor);
		
		/* save doctorSchedule */
		return doctorScheduleRepo.save(doctorSchedule);
	}

	public List<Doctor> getAll() {
		 
		return doctorRepo.findAll();
	}

	public List<DoctorSchedule> getAllSchedule(String username) {
		 
		return doctorScheduleRepo.getByUsername(username);
	}
}
