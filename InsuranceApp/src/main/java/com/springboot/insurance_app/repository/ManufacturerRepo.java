package com.springboot.insurance_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.insurance_app.model.Manufacturer;

public interface ManufacturerRepo extends JpaRepository<Manufacturer, Integer> {

}
