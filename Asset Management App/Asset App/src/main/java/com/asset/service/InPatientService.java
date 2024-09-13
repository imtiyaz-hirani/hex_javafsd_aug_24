package com.asset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asset.repo.InPatientRepo;

@Service
public class InPatientService {

	@Autowired
	private InPatientRepo inPatientRepo;
}
