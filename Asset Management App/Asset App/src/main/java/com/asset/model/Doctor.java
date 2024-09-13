package com.asset.model;

import com.asset.enums.DoctorSpecialization;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name; 
	
	@Enumerated(EnumType.STRING)
	private DoctorSpecialization doctorSpecialization;
	
	@OneToOne
	private UserInfo user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DoctorSpecialization getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(DoctorSpecialization doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	} 
	
	
}
