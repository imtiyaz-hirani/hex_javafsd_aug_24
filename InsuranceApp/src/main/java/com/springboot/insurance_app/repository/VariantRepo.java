package com.springboot.insurance_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.insurance_app.model.Variant;

public interface VariantRepo extends JpaRepository<Variant, Integer>{

}
