package com.asset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asset.exception.InvalidIdException;
import com.asset.model.Doctor;
import com.asset.model.DoctorSchedule;
import com.asset.service.DoctorService;
import com.asset.service.InPatientService;

@RestController
public class DoctorController {

	@Autowired
	private InPatientService inPatientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/doctor/add")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDcotor(doctor);
	}
	
	@PostMapping("/doctor/schedule/add/{doctorId}")
	public ResponseEntity<?> addDoctorSchedule(@PathVariable int doctorId, @RequestBody DoctorSchedule doctorSchedule) {
		try {
			DoctorSchedule ds=doctorService.addDoctorSchedule(doctorId,doctorSchedule);
			return ResponseEntity.ok(ds);
			
		} catch (InvalidIdException e) {
			 return ResponseEntity.badRequest().body(e.getMessage()); 
		}
	}
}
