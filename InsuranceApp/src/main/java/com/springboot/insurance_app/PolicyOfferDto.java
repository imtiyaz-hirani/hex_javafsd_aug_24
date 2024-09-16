package com.springboot.insurance_app;

import org.springframework.stereotype.Component;

import com.springboot.insurance_app.enums.PolicyType;
import com.springboot.insurance_app.enums.VehicleOwnership;
import com.springboot.insurance_app.enums.VehicleType;
import com.springboot.insurance_app.model.Vehicle;

@Component
public class PolicyOfferDto {
	private Vehicle vehicle;
	private VehicleType vehicleType;
	private VehicleOwnership vehicleOwnership;
	private double actualPrice;
	private String yearOfManufacturing;
	private String mileage;
	private PolicyType policyType;
	private double premiumAmount;

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public VehicleOwnership getVehicleOwnership() {
		return vehicleOwnership;
	}

	public void setVehicleOwnership(VehicleOwnership vehicleOwnership) {
		this.vehicleOwnership = vehicleOwnership;
	}

	public double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public String getYearOfManufacturing() {
		return yearOfManufacturing;
	}

	public void setYearOfManufacturing(String yearOfManufacturing) {
		this.yearOfManufacturing = yearOfManufacturing;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public PolicyType getPolicyType() {
		return policyType;
	}

	public void setPolicyType(PolicyType policyType) {
		this.policyType = policyType;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

}
