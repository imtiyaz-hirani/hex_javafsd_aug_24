package com.asset.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.asset.exception.AppointmentUnavailableException;
import com.asset.exception.InvalidIdException;
import com.asset.model.Doctor;
import com.asset.model.DoctorSchedule;
import com.asset.model.Medication;
import com.asset.model.PatientDoctor;
import com.asset.model.PatientHistory;
import com.asset.model.PatientOPD;
import com.asset.model.UserInfo;
import com.asset.repo.DoctorRepo;
import com.asset.repo.DoctorScheduleRepo;
import com.asset.repo.MedicationRepo;
import com.asset.repo.PatientDoctorRepo;
import com.asset.repo.PatientHistoryRepo;
import com.asset.repo.PatientOPDRepo;
import com.asset.repo.UserRepository;

@Service
public class PatientOPDService {

	@Autowired
	private PatientOPDRepo patientOPDRepo;

	@Autowired
	private PatientHistoryRepo patientHistoryRepo;
	
	@Autowired
	private MedicationRepo medicationRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Autowired
	private PatientDoctorRepo patientDoctorRepo;
	
	@Autowired
	private DoctorScheduleRepo doctorScheduleRepo;
	
	public PatientOPD addPatientt(PatientOPD patientOPD) {
		 UserInfo userInfo = patientOPD.getUser();
		 userInfo.setRole("ROLE_PATIENT");
		 userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		 userInfo=  userRepository.save(userInfo);
		 patientOPD.setUser(userInfo);
		 
		return patientOPDRepo.save(patientOPD);
	}

	public PatientHistory addPatientHistory(int pid, PatientHistory patientHistory) throws InvalidIdException {
		//fetch PatinetOPD basis pid
		Optional<PatientOPD> optional =  patientOPDRepo.findById(pid);
		if(optional.isEmpty())
			throw new InvalidIdException("Patient ID Invalid"); 
		
		PatientOPD patientOPD = optional.get();
		patientHistory.setPatientOPD(patientOPD);
		return patientHistoryRepo.save(patientHistory);
	}

	public Medication addPatientMedication(int historyId, Medication medication) throws InvalidIdException {
		//fetch PatientHistory basis historyId
		Optional<PatientHistory> optional =  patientHistoryRepo.findById(historyId);
		if(optional.isEmpty())
			throw new InvalidIdException("Patient ID Invalid"); 
		
		PatientHistory patientHistory = optional.get();
		medication.setPatientHistory(patientHistory);
		
		return medicationRepo.save(medication);
		
	}

	public PatientDoctor bookAppointment(int patientId, int doctorId, PatientDoctor patientDoctor) throws AppointmentUnavailableException {
		PatientOPD patientOPD =  patientOPDRepo.findById(patientId).get(); 
		Doctor doctor =  doctorRepo.findById(doctorId).get(); 
		patientDoctor.setDoctor(doctor);
		patientDoctor.setPatientOpd(patientOPD);
		
		//check if given date is available 
		List<DoctorSchedule> doctorSchedule =  doctorRepo.getScheduleByDoctorId(doctorId);
		
		//reduce the list to only date 
		List<LocalDate> listDates =  doctorSchedule.stream().map(e->e.getDate()).toList();
		
		if(! (listDates.contains(patientDoctor.getDateOfAppointment()))) {
			throw new AppointmentUnavailableException("Appointment not available at this date"); 
		}
		
		List<String> listSlots = new ArrayList<>();
		for( DoctorSchedule ds :doctorSchedule ) {
			String fromTime = ds.getFromTime().toString().split(":00.000000")[0];
			String toTime = ds.getToTime().toString().split(":00.000000")[0];
			String slot = fromTime + "-" + toTime;
			listSlots.add(slot);
		}
		System.out.println("----list of all slots------");
		listSlots.stream().forEach(System.out :: println);
		
		System.out.println("Given slot: " + patientDoctor.getSlot());
		
		//check if given slot is in the list of  available slots 
		if( !(listSlots.contains(patientDoctor.getSlot()))) {
			throw new AppointmentUnavailableException("Appointment not available at this slot"); 
		}
		
		//check number of appointment availability 
		LocalTime fromTime = LocalTime.parse(patientDoctor.getSlot().split("-")[0]);    //10.00-12.00
		LocalTime toTime = LocalTime.parse(patientDoctor.getSlot().split("-")[1]);
		
		DoctorSchedule ds = doctorScheduleRepo.getNumberOfAppointmentCount(patientDoctor.getDateOfAppointment(), fromTime, toTime);
		if(ds.getNumberOfAppt() < 1) {
			throw new AppointmentUnavailableException("Appointments are full at this slot"); 
		}
		
		//book an appointment 
		patientDoctor.setDateOfBooking(LocalDate.now());
		ds.setNumberOfAppt(ds.getNumberOfAppt() - 1);; 
		doctorScheduleRepo.save(ds);
		return patientDoctorRepo.save(patientDoctor);
	}
}
