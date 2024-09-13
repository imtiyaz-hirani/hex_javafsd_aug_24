package com.asset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asset.exception.AppointmentUnavailableException;
import com.asset.exception.InvalidIdException;
import com.asset.model.Medication;
import com.asset.model.PatientDoctor;
import com.asset.model.PatientHistory;
import com.asset.model.PatientOPD;
import com.asset.service.PatientOPDService;

@RestController
public class PatinetOPDController {

	@Autowired
	private PatientOPDService patientOPDService;
	
	@PostMapping("/patient-opd/add")
	public PatientOPD addPatientt(@RequestBody PatientOPD patientOPD) {
		
		return patientOPDService.addPatientt(patientOPD);
	}
	
	@PostMapping("/patient-opd/history/add/{pid}")
	public ResponseEntity<?> addPatientHistory(@PathVariable int pid, @RequestBody PatientHistory patientHistory) {
		try {
			patientHistory =  patientOPDService.addPatientHistory(pid,patientHistory);
			return ResponseEntity.ok(patientHistory); 
			
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage()); 
		}
	}
	
	@PostMapping("/patient-opd/history/medicine-info/add/{historyId}")
	public ResponseEntity<?> addPatientMedication(@PathVariable int historyId, @RequestBody Medication medication) {
		try {
			medication =patientOPDService.addPatientMedication(historyId, medication);	
			return ResponseEntity.ok(medication); 
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage()); 
		}
	}
	
	@PostMapping("/book-appointment/{patientId}/{doctorId}")
	public ResponseEntity<?> bookAppointment(@PathVariable int patientId, @PathVariable int doctorId,  @RequestBody PatientDoctor patientDoctor ) {
		try {
			patientDoctor =  patientOPDService.bookAppointment(patientId, doctorId, patientDoctor);
			return ResponseEntity.ok(patientDoctor); 
		} catch (AppointmentUnavailableException e) {
			return ResponseEntity.badRequest().body(e.getMessage()); 
		} 
	}
}
