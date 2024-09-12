package com.asset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asset.repo.EmployeeAssetRepository;

@Service
public class EmployeeAssetService {

	@Autowired
	private EmployeeAssetRepository employeeAssetRepository;
}
