package com.hibernate.main.model;

import java.util.List;

import com.hibernate.main.enums.BusTravelDays;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bus_route")
public class BusRoute { //br  
	//br.ticket    br.double 
	//br.bus       br.Bus
	@Id
	private int id;
	
	@ManyToOne
	private Bus bus; 
	
	@ManyToOne
	private Route route;
	
	@Enumerated(EnumType.STRING)
	private BusTravelDays travelDays;
	
	private String travelTime;
	
	private double ticket; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	 

	public double getTicket() {
		return ticket;
	}

	public void setTicket(double ticket) {
		this.ticket = ticket;
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

	@Override
	public String toString() {
		return "BusRoute [id=" + id + ", bus=" + bus + ", route=" + route + ", travelDays=" + travelDays
				+ ", travelTime=" + travelTime + ", ticket=" + ticket + "]";
	}
	
	
}
/*
 *   Bus 1:M	BusRoute	M:1  Route 
 * 
 * 
 */