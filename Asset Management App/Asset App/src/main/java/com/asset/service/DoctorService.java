package com.asset.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.asset.dto.AppointmentStatDto;
import com.asset.enums.Day;
import com.asset.enums.Week;
import com.asset.exception.InvalidIdException;
import com.asset.exception.InvalidInputException;
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

	public Page<DoctorSchedule> getAllSchedule(String username, Pageable pageable) {
		 
		return doctorScheduleRepo.getByUsername(username,pageable);
	}

	public List<DoctorSchedule> getAppointmentStats(String username, Week week) throws InvalidInputException {
		switch(week.toString()) {
		case "CURRENT":
			// compute from and to date of current week 
			LocalDate today =  LocalDate.now();
			//date that represents start of the week MON-SAT 
			LocalDate fromDate = today.with(DayOfWeek.MONDAY); 
			LocalDate toDate = today.with(DayOfWeek.MONDAY).plusDays(6);
			List<DoctorSchedule> list =  doctorRepo.getAppointmentStats(fromDate,toDate,username); 
			return list; 
			 
		case "PREVIOUS":{
			// compute from and to date of previous week 
			 today =  LocalDate.now();
			 fromDate = today.with(DayOfWeek.MONDAY).minusWeeks(1);
			 toDate = today.with(DayOfWeek.MONDAY).plusDays(6).minusWeeks(1);
			 list =  doctorRepo.getAppointmentStats(fromDate,toDate,username); 
			 return list; 
		}
		 default:
			 throw new InvalidInputException("Value of week can be either CURRENT or PREVIOUS"); 
		}
	
	}

	public AppointmentStatDto convertToDto(List<DoctorSchedule> list, AppointmentStatDto appointmentStatDto) {
		List<String> listLabel = new ArrayList<>();
		List<Integer> listData = new ArrayList<>();
		
		for( Day d : Day.values() ) {
			int toalAppointment = list.stream()
									.filter(e-> e.getDay().equals(d))
									.collect(Collectors.summingInt(e->e.getNumberOfAppt()));
		    //10 - 4
			listLabel.add(d.toString());
			listData.add(toalAppointment);
		}
		appointmentStatDto.setLabels(listLabel);
		appointmentStatDto.setData(listData);
		return appointmentStatDto;
	}
}
