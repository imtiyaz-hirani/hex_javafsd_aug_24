package com.hibernate.main.dto;

import com.hibernate.main.enums.BusTravelDays;

public class BusDto {
	
	private int id;
	private String busNumber;
	private BusTravelDays travelDays;
	private String travelTime;
	private double ticket;
	private String sourceStation; 
	private String destinationStation; 
	private int distance;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public BusTravelDays getTravelDays() {
		return travelDays;
	}
	public void setTravelDays(BusTravelDays travelDays) {
		this.travelDays = travelDays;
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public double getTicket() {
		return ticket;
	}
	public void setTicket(double ticket) {
		this.ticket = ticket;
	}
	public String getSourceStation() {
		return sourceStation;
	}
	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}
	public String getDestinationStation() {
		return destinationStation;
	}
	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "BusDto [id=" + id + ", busNumber=" + busNumber + ", travelDays=" + travelDays + ", travelTime="
				+ travelTime + ", ticket=" + ticket + ", sourceStation=" + sourceStation + ", destinationStation="
				+ destinationStation + ", distance=" + distance + "]";
	}
	
	
}
