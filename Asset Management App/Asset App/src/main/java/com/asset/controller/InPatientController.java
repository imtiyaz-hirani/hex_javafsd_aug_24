package com.asset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.asset.service.InPatientService;

@RestController
public class InPatientController {

	@Autowired
	private InPatientService inPatientService;
}
