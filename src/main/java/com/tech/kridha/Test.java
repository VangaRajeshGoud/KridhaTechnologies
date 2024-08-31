package com.tech.kridha;

import java.util.HashMap;
import java.util.Map;

import com.tech.kridha.request.JobsInfo;

public class Test {

	
	public static void main(String[] args) {
		Map<String, JobsInfo> jobMap = new HashMap<>();

		jobMap.put("java_backend_developer", new JobsInfo(
			    "Java Backend Developer", 
			    "Focuses on backend development using Java, Spring Boot, Microservices, and SQL for data management and service integration.", 
			    "Chennai, India", 
			    "Full-Time",
			    "Roles & Responsibilities: Develop and maintain backend services, collaborate with front-end developers, and optimize SQL queries.",
			    "Experience: 5+ years"
			));
		
		JobsInfo job = jobMap.get("java_backend_developer");

		System.out.println(job.getTitle());
		System.out.println(job.getLocation());
		System.out.println(job.getEmploymentType());
		System.out.println(job.getDescription());
		System.out.println(job.getRolesResponsibilities()); // Make sure this isn't null or undefined
		System.out.println(job.getExperience()); // Make sure this isn't null or undefined


	}
}
