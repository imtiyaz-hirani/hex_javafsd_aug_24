package com.springframework.myspringapp.model;

public class Category {
	private int id;
	private String name;
	private int sequence;

	public Category(int id, String name, int sequence) {
		super();
		this.id = id;
		this.name = name;
		this.sequence = sequence;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

}
