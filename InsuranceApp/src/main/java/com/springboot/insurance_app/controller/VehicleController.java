package com.springboot.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.insurance_app.exception.InvalidIdException;
import com.springboot.insurance_app.model.Manufacturer;
import com.springboot.insurance_app.model.Vehicle;
import com.springboot.insurance_app.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/manufacturer/add")
	public Manufacturer addmanufacturer(@RequestBody Manufacturer manufacturer) {
		return vehicleService.add(manufacturer);
	}
	
	@PostMapping("/vehicle/add/{mid}")
	public ResponseEntity<?> addVehicle(@PathVariable int mid,  @RequestBody Vehicle vehicle ) {
		/*
		 * -- Incorrect Approach 
		 * Manufacturer manufacturer = vehicle.getManufacturer(); manufacturer =
		 * vehicleService.postManufacturer(manufacturer);
		 * 
		 * vehicle.setManufacturer(manufacturer);
		 * 
		 * vehicleService.addVehicle(vehicle);
		 */
		
		try {
			Manufacturer manufacturer =  vehicleService.getManufacturerById(mid);
			vehicle.setManufacturer(manufacturer);
			vehicle = vehicleService.addVehicle(vehicle);
			return ResponseEntity.ok(vehicle); 
			
		} catch (InvalidIdException e) {
		    return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
}
