package com.main.model;

public class Address {
	private int id;
	private String streetAddress;
	private String city;
	private String country;

	public Address(int id, String streetAddress, String city, String country) {

		this.id = id;
		this.streetAddress = streetAddress;
		this.city = city;
		this.country = country;
	}

	public Address() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", streetAddress=" + streetAddress + ", city=" + city + ", country=" + country
				+ "]";
	}

}
