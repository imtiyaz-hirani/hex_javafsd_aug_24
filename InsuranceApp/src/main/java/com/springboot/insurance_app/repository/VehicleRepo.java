package com.springboot.insurance_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.insurance_app.model.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{

}
