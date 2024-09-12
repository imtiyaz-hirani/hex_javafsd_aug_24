package com.asset.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer>{

}
