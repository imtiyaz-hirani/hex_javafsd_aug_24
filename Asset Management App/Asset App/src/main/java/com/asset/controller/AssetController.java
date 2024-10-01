package com.asset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/get/{id}")
	public Asset getById(@PathVariable int id) {
		return assetService.getById(id);
	}//401 Unauthorized, 500 Internal Server Error, 404 NOT_FOUND, 200 OK/201 OK  
}
