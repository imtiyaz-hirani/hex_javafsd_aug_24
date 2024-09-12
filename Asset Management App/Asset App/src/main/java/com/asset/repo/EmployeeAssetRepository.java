package com.asset.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset.model.EmployeeAsset;

public interface EmployeeAssetRepository extends JpaRepository<EmployeeAsset, Integer> {

}
