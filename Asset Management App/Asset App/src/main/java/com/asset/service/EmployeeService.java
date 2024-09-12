package com.asset.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.asset.enums.AssetStatus;
import com.asset.exception.InvalidIdException;
import com.asset.model.Asset;
import com.asset.model.Employee;
import com.asset.model.EmployeeAsset;
import com.asset.model.UserInfo;
import com.asset.repo.AssetRepository;
import com.asset.repo.EmployeeAssetRepository;
import com.asset.repo.EmployeeRepository;
import com.asset.repo.UserRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AssetRepository assetRepository;
	
	@Autowired
	private EmployeeAssetRepository employeeAssetRepository;
	
	public Employee addEmployee(Employee employee) {
		//detach user info from employee
		UserInfo userInfo = employee.getUser();
		userInfo.setRole("ROLE_EMPLOYEE");
		//encode the password 
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		
		userInfo = userRepository.save(userInfo); //fully defined user with id 
		
		//attach it to employee
		employee.setUser(userInfo);
		
		//save employee
	   return employeeRepository.save(employee);
	}
	public EmployeeAsset requestAsset(String empUsername, int assetId) throws InvalidIdException {
		Optional<Asset> optional =  assetRepository.findById(assetId); 
		if(optional.isEmpty()) {
			throw new InvalidIdException("Asset ID Invalid"); 
		}
		Asset asset =  optional.get();
		//fetch employee basis username 
		Employee employee = employeeRepository.getEmployee(empUsername);
		
		EmployeeAsset empAsset = new EmployeeAsset();
		empAsset.setEmployee(employee);
		empAsset.setAsset(asset);
		empAsset.setBorrowingDate(LocalDate.now());
		empAsset.setStatus(AssetStatus.pending);
		
		return employeeAssetRepository.save(empAsset);
	}
}
