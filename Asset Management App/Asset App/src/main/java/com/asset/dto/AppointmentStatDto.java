package com.asset.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AppointmentStatDto {
	private List<String> labels; 
	private List<Integer> data;
	private String week;
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	public List<Integer> getData() {
		return data;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	} 
	
	
}
