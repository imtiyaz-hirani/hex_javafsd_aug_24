package com.asset.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asset.enums.Day;
import com.asset.exception.InvalidIdException;
import com.asset.model.Doctor;
import com.asset.model.DoctorSchedule;
import com.asset.service.DoctorService;
import com.asset.service.InPatientService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class DoctorController {

	@Autowired
	private InPatientService inPatientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/doctor/add")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDcotor(doctor);
	}
	
	@PostMapping("/doctor/schedule/add")
	public ResponseEntity<?> addDoctorSchedule(Principal principal, @RequestBody DoctorSchedule doctorSchedule) {
		try {
			DoctorSchedule ds=doctorService.addDoctorSchedule(principal.getName(),doctorSchedule);
			return ResponseEntity.ok(ds);
			
		} catch (InvalidIdException e) {
			 return ResponseEntity.badRequest().body(e.getMessage()); 
		}
	}
	@GetMapping("/doctor/all")
	public List<Doctor> getAll(){
		return doctorService.getAll();
	}
	
	@GetMapping("/doctor/days")
	public List<Day> getAllDays(){
		return List.of(Day.values());
	}
}
