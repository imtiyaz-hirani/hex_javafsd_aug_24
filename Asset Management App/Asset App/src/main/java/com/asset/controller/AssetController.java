package com.asset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asset.model.Asset;
import com.asset.service.AssetService;

@RestController
@RequestMapping("/asset")
public class AssetController {

	@Autowired
	private AssetService assetService;
	
	@PostMapping("/add")
	public Asset addAsset(@RequestBody Asset asset) {
		return assetService.addAsset(asset);
	}
}
