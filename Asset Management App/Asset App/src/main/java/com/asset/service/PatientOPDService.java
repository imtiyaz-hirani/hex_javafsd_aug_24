package com.asset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import com.asset.repo.PatientOPDRepo;

@Service
public class PatientOPDService {

	@Autowired
	private PatientOPDRepo patientOPDRepo;
}
