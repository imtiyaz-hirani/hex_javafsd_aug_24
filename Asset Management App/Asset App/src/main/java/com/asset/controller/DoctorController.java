package com.asset.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asset.dto.AppointmentStatDto;
import com.asset.enums.Day;
import com.asset.enums.Week;
import com.asset.exception.InvalidIdException;
import com.asset.exception.InvalidInputException;
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
			doctorSchedule.validate(doctorSchedule);
			DoctorSchedule ds=doctorService.addDoctorSchedule(principal.getName(),doctorSchedule);
			return ResponseEntity.ok(ds);
			
		}
		catch (InvalidInputException  e) {
			 return ResponseEntity.status(e.getStatusCode()).body(e.getMessage()); 
		}
		catch (InvalidIdException e ) {
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
	
	@GetMapping("/doctor/schedule/all")
	public Page<DoctorSchedule> getAllSchedule(Principal principal,
			@RequestParam(defaultValue = "0", required = false) Integer page, 
			@RequestParam(defaultValue = "1000", required = false) Integer size  ){
		
		Pageable pageable =   PageRequest.of(page, size);
		
		return doctorService.getAllSchedule(principal.getName(),pageable);
	}
	
	@GetMapping("/doctor/appointment/stats/{week}")
	public ResponseEntity<?> getAppointmentStats(Principal principal,@PathVariable  Week week , AppointmentStatDto appointmentStatDto) {
		String username = principal.getName();
		try {
			List<DoctorSchedule> list =  doctorService.getAppointmentStats(username,week);
			appointmentStatDto = doctorService.convertToDto(list,appointmentStatDto);
			appointmentStatDto.setWeek(week.toString());
			return ResponseEntity.ok(appointmentStatDto);
		} catch (InvalidInputException e) {
			return ResponseEntity.status(305).body(e.getMessage()); 
		}
	}
}
