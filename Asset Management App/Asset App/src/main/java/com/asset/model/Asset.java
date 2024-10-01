package com.asset.model;

import com.asset.enums.AssetCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int assetNo;
	
	private String assetName;
	
	@Enumerated(EnumType.STRING)
	private AssetCategory assetCategory;
	
	private double assetValue;  
	
	private int quantity;

	public int getAssetNo() {
		return assetNo;
	}

	public void setAssetNo(int assetNo) {
		this.assetNo = assetNo;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public AssetCategory getAssetCategory() {
		return assetCategory;
	}

	public void setAssetCategory(AssetCategory assetCategory) {
		this.assetCategory = assetCategory;
	}

	public double getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(double assetValue) {
		this.assetValue = assetValue;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 
	
	
}
