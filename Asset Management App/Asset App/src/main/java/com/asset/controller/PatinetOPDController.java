package com.asset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.asset.service.PatientOPDService;

@RestController
public class PatinetOPDController {

	@Autowired
	private PatientOPDService patientOPDService;
}
