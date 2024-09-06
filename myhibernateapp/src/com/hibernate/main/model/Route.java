package com.hibernate.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Route {

	@Id
	private int id; 
	
	private String sourceStation; 
	
	private String destinationStation; 
	
	private int distance; 
	
	
	private String details;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	 

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", sourceStation=" + sourceStation + ", destinationStation=" + destinationStation
				+ ", distance=" + distance + ", details=" + details + "]";
	}
	
	
	
}
