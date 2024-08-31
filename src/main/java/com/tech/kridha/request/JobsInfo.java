package com.tech.kridha.request;

//src/main/java/com/example/demo/model/JobsInfo.java
public class JobsInfo {
	private String title;
	private String description;
	private String location;
	private String employmentType;
	private String rolesResponsibilities;
	private String experience;

	// Constructor
	public JobsInfo(String title, String description, String location, String employmentType) {
		this.title = title;
		this.description = description;
		this.location = location;
		this.employmentType = employmentType;
	}

	// Overloaded constructor with roles & responsibilities and experience
	public JobsInfo(String title, String description, String location, String employmentType,
			String rolesResponsibilities, String experience) {
		this.title = title;
		this.description = description;
		this.location = location;
		this.employmentType = employmentType;
		this.rolesResponsibilities = rolesResponsibilities;
		this.experience = experience;
	}

	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getRolesResponsibilities() {
		return rolesResponsibilities;
	}

	public void setRolesResponsibilities(String rolesResponsibilities) {
		this.rolesResponsibilities = rolesResponsibilities;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "JobsInfo [title=" + title + ", description=" + description + ", location=" + location
				+ ", employmentType=" + employmentType + ", rolesResponsibilities=" + rolesResponsibilities
				+ ", experience=" + experience + "]";
	}
}
