package com.springboot.my_boot_app.dto;

public class ProjectEmployeeStatDto {
	private String projectType;
	private long numberOfEmployee;

	public ProjectEmployeeStatDto(String projectType, long numberOfEmployee) {
		super();
		this.projectType = projectType;
		this.numberOfEmployee = numberOfEmployee;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public long getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(long numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

}
