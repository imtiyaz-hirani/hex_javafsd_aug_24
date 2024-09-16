package com.springboot.insurance_app.model;

import com.springboot.insurance_app.enums.OfferStatus;
import com.springboot.insurance_app.enums.PolicyType;
import com.springboot.insurance_app.enums.VehicleOwnership;
import com.springboot.insurance_app.enums.VehicleType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
 
@Entity
public class PolicyOffer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Vehicle vehicle;  //2 offers : com,tp 
	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;
	@Enumerated(EnumType.STRING)
	private VehicleOwnership vehicleOwnership;
	private double actualPrice;
	private String yearOfManufacturing;
	private String mileage;
	@Enumerated(EnumType.STRING)
	private PolicyType policyType;
	private double premiumAmount;

	@Enumerated(EnumType.STRING)
	private OfferStatus offerStatus;
	@ManyToOne
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public OfferStatus getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(OfferStatus offerStatus) {
		this.offerStatus = offerStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
