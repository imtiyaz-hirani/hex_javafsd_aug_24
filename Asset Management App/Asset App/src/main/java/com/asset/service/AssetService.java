package com.asset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asset.model.Asset;
import com.asset.repo.AssetRepository;

@Service
public class AssetService {

	@Autowired
	private AssetRepository assetRepository;

	public Asset addAsset(Asset asset) {
		 
		return assetRepository.save(asset);
	}
}
