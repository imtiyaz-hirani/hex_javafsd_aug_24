package com.springboot.insurance_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.insurance_app.exception.InvalidIdException;
import com.springboot.insurance_app.model.Manufacturer;
import com.springboot.insurance_app.model.Vehicle;
import com.springboot.insurance_app.repository.ManufacturerRepo;
import com.springboot.insurance_app.repository.VariantRepo;
import com.springboot.insurance_app.repository.VehicleRepo;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepo vehicleRepo;
	
	@Autowired
	private ManufacturerRepo manufacturerRepo;
	
	@Autowired
	private VariantRepo variantRepo;

	public Vehicle addVehicle(Vehicle vehicle) {
		return vehicleRepo.save(vehicle);
		
	}

	public Manufacturer postManufacturer(Manufacturer manufacturer) {
		 
		return manufacturerRepo.save(manufacturer);
	}

	public Manufacturer getManufacturerById(int mid) throws InvalidIdException {
		 Optional<Manufacturer>  optional = manufacturerRepo.findById(mid); 
		 if(optional.isEmpty()) {
			 throw new InvalidIdException("Invalid ID given"); 
		 } 
			
		 return optional.get(); 
		 
		
	}

	public Manufacturer add(Manufacturer manufacturer) {
		return manufacturerRepo.save(manufacturer);
		
	}
}
