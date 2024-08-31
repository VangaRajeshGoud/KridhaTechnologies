package com.tech.kridha.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tech.kridha.request.JobsInfo;
import com.tech.kridha.service.EmailService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class JobController {

	@Autowired
	EmailService emailService;

	private Map<String, JobsInfo> jobMap = new HashMap<>();

	public JobController() {
		// Software Engineer
		jobMap.put("software_engineer", new JobsInfo("Software Engineer",
		    "Develops and maintains software applications. Requires proficiency in programming languages like Java, Python, or C#, and experience with software development life cycle (SDLC).",
		    "Hyderabad, India", "Full-Time",
		    "Roles & Responsibilities: Write clean, scalable code; collaborate with cross-functional teams; and participate in code reviews.",
		    "Experience: 2-4 years"));

		// DevOps Engineer
		jobMap.put("devops_engineer", new JobsInfo("DevOps Engineer",
		    "Manages infrastructure and deployment processes. Requires knowledge of CI/CD pipelines, containerization tools like Docker, and orchestration platforms like Kubernetes.",
		    "Hyderabad, India", "Full-Time",
		    "Roles & Responsibilities: Automate deployments, manage cloud infrastructure, and ensure system reliability.",
		    "Experience: 3-5 years"));

		// Data Scientist
		jobMap.put("data_scientist", new JobsInfo("Data Scientist",
		    "Analyzes data and builds predictive models. Proficiency in machine learning algorithms, Python/R, and data visualization tools is required.",
		    "Boston, MA", "Contract",
		    "Roles & Responsibilities: Develop predictive models, interpret data trends, and collaborate with stakeholders to solve business problems.",
		    "Experience: 4-6 years"));

		// Java Jobs
		jobMap.put("java_developer", new JobsInfo("Java Developer", 
		    "Designs, implements, and maintains Java-based applications using technologies like Spring Boot, Microservices, and SQL.",
		    "Bangalore, India", "Full-Time",
		    "Roles & Responsibilities: Write and maintain Java code, participate in software design, and ensure application performance.",
		    "Experience: 3+ years"));

		jobMap.put("senior_java_developer", new JobsInfo("Senior Java Developer", 
		    "Leads the design and development of complex Java applications, leveraging Spring Boot, Microservices, and SQL databases for scalable solutions.",
		    "Pune, India", "Full-Time",
		    "Roles & Responsibilities: Lead technical teams, design system architecture, and mentor junior developers.",
		    "Experience: 7+ years"));

		jobMap.put("java_backend_developer", new JobsInfo("Java Backend Developer", 
		    "Focuses on backend development using Java, Spring Boot, Microservices, and SQL for data management and service integration.",
		    "Chennai, India", "Full-Time",
		    "Roles & Responsibilities: Develop RESTful services, integrate databases, and optimize server-side logic.",
		    "Experience: 5+ years"));

		jobMap.put("java_fullstack_developer", new JobsInfo("Java Fullstack Developer", 
		    "Develops both front-end and back-end components of Java applications, with expertise in Spring Boot, Microservices, and SQL.",
		    "Mumbai, India", "Full-Time",
		    "Roles & Responsibilities: Design user interfaces, develop APIs, and ensure seamless front-to-back integration.",
		    "Experience: 4+ years"));

		jobMap.put("java_microservices_developer", new JobsInfo("Java Microservices Developer", 
		    "Specializes in building microservices architecture using Java, Spring Boot, and SQL for distributed and scalable applications.",
		    "Hyderabad, India", "Full-Time",
		    "Roles & Responsibilities: Design and implement microservices, manage service deployments, and ensure high availability.",
		    "Experience: 6+ years"));

		jobMap.put("java_spring_developer", new JobsInfo("Java Spring Developer", 
		    "Develops enterprise-level applications using the Spring framework, including Spring Boot, and integrates with Microservices and SQL.",
		    "Noida, India", "Full-Time",
		    "Roles & Responsibilities: Build Spring-based applications, integrate with databases, and ensure security and compliance.",
		    "Experience: 5+ years"));

		jobMap.put("java_automation_engineer", new JobsInfo("Java Automation Engineer", 
		    "Automates testing processes and builds CI/CD pipelines using Java, Spring Boot, and SQL databases.",
		    "Kolkata, India", "Full-Time",
		    "Roles & Responsibilities: Develop automated tests, manage continuous integration, and improve testing efficiency.",
		    "Experience: 3+ years"));

		jobMap.put("java_integration_specialist", new JobsInfo("Java Integration Specialist", 
		    "Focuses on integrating various systems and services using Java, Spring Boot, Microservices, and SQL.",
		    "Delhi, India", "Full-Time",
		    "Roles & Responsibilities: Design integration solutions, manage data flows, and ensure system interoperability.",
		    "Experience: 6+ years"));

		jobMap.put("java_architect", new JobsInfo("Java Architect", 
		    "Designs and oversees the architecture of complex Java-based systems, ensuring optimal use of Spring Boot, Microservices, and SQL technologies.",
		    "Ahmedabad, India", "Full-Time",
		    "Roles & Responsibilities: Define system architecture, lead development teams, and ensure scalability and performance.",
		    "Experience: 10+ years"));

		jobMap.put("java_support_engineer", new JobsInfo("Java Support Engineer", 
		    "Provides support and troubleshooting for Java applications, particularly those using Spring Boot, Microservices, and SQL.",
		    "Hyderabad, India", "Full-Time",
		    "Roles & Responsibilities: Monitor applications, resolve incidents, and collaborate with development teams.",
		    "Experience: 2+ years"));

		// Angular Jobs
		jobMap.put("angular_developer", new JobsInfo("Angular Developer", 
		    "Develops dynamic front-end applications using Angular. Requires proficiency in Angular, TypeScript, and responsive design.",
		    "Hyderabad, India", "Full-Time",
		    "Roles & Responsibilities: Develop UI components, optimize front-end performance, and collaborate with backend developers.",
		    "Experience: 3+ years"));

		jobMap.put("senior_angular_developer", new JobsInfo("Senior Angular Developer", 
		    "Leads the development of complex Angular-based front-end systems. Requires advanced knowledge of Angular and front-end architecture.",
		    "Pune, India", "Full-Time",
		    "Roles & Responsibilities: Lead UI development, mentor junior developers, and ensure cross-browser compatibility.",
		    "Experience: 6+ years"));

		jobMap.put("angular_ui_developer", new JobsInfo("Angular UI Developer", 
		    "Focuses on user interface design and development using Angular. Requires experience with Angular, CSS, and UX principles.",
		    "Mumbai, India", "Full-Time",
		    "Roles & Responsibilities: Design UI layouts, implement UX best practices, and ensure pixel-perfect design.",
		    "Experience: 4+ years"));

		// React Jobs
		jobMap.put("react_developer", new JobsInfo("React Developer", 
		    "Builds interactive user interfaces using React.js. Requires experience with React, Redux, and RESTful APIs.",
		    "Chennai, India", "Full-Time",
		    "Roles & Responsibilities: Develop React components, manage state with Redux, and integrate with APIs.",
		    "Experience: 3+ years"));

		jobMap.put("senior_react_developer", new JobsInfo("Senior React Developer", 
		    "Leads the development of advanced front-end applications using React. Requires advanced React skills and experience with front-end architecture.",
		    "Bangalore, India", "Full-Time",
		    "Roles & Responsibilities: Architect front-end solutions, optimize performance, and mentor junior developers.",
		    "Experience: 6+ years"));

		jobMap.put("react_native_developer", new JobsInfo("React Native Developer", 
		    "Develops mobile applications using React Native. Requires experience with React Native, mobile app development, and cross-platform frameworks.",
		    "Delhi, India", "Full-Time",
		    "Roles & Responsibilities: Build mobile apps, optimize for performance, and manage app store deployments.",
		    "Experience: 4+ years"));

		jobMap.put("react_ui_developer", new JobsInfo("React UI Developer", 
		    "Specializes in building user interfaces with React.js. Requires experience with React, CSS-in-JS, and UI/UX design.",
		    "Hyderabad, India", "Full-Time",
		    "Roles & Responsibilities: Design UI components, ensure responsive design, and collaborate with design teams.",
		    "Experience: 3+ years"));

		// DevOps Job
		jobMap.put("devops_engineer", new JobsInfo("DevOps Engineer", 
		    "Manages infrastructure and deployment processes. Requires experience with CI/CD, Docker, Kubernetes, and cloud platforms.",
		    "Hyderabad, India", "Full-Time",
		    "Roles & Responsibilities: Automate deployments, monitor system performance, and ensure high availability.",
		    "Experience: 4+ years"));

		// Salesforce Job
		jobMap.put("salesforce_developer", new JobsInfo("Salesforce Developer", 
		    "Customizes and develops solutions on the Salesforce platform. Requires experience with Apex, Visualforce, and Salesforce integrations.",
		    "Pune, India", "Full-Time",
		    "Roles & Responsibilities: Develop custom Salesforce solutions, integrate with external systems, and manage Salesforce environments.",
		    "Experience: 3+ years"));

		// Freshers Jobs
		jobMap.put("software_engineer_fresher", new JobsInfo("Software Engineer Fresher", 
		    "Entry-level position for software development. Requires knowledge of basic programming concepts and a willingness to learn.",
		    "Bangalore, India", "Full-Time",
		    "Roles & Responsibilities: Assist in coding tasks, participate in code reviews, and learn from senior developers.",
		    "Experience: 0-1 year"));

		jobMap.put("java_developer_fresher", new JobsInfo("Java Developer Fresher", 
		    "Entry-level Java developer position for building and maintaining Java applications. Requires understanding of Java basics and OOP principles.",
		    "Chennai, India", "Full-Time",
		    "Roles & Responsibilities: Write simple Java code, assist in debugging, and learn advanced Java concepts.",
		    "Experience: 0-1 year"));

		jobMap.put("angular_developer_fresher", new JobsInfo("Angular Developer Fresher", 
		    "Entry-level position for front-end development using Angular. Requires basic knowledge of HTML, CSS, JavaScript, and Angular.",
		    "Hyderabad, India", "Full-Time",
		    "Roles & Responsibilities: Develop basic UI components, assist in front-end coding, and learn Angular framework.",
		    "Experience: 0-1 year"));

		// SAP Jobs
		jobMap.put("sap_finance_controlling_specialist", new JobsInfo("SAP Finance and Controlling Specialist",
		    "Specializes in SAP Finance and Controlling module, with expertise in configuring and maintaining financial processes. Requires knowledge of SAP FICO module and integration with other SAP modules.",
		    "Bangalore, India", "Full-Time",
		    "Roles & Responsibilities: Configure SAP FICO settings, manage financial reporting, and collaborate with business stakeholders.",
		    "Experience: 5+ years"));

		jobMap.put("sap_hana_specialist", new JobsInfo("SAP HANA Specialist", 
		    "Expert in SAP HANA database management and integration. Requires experience with SAP HANA, SQL, and database optimization.",
		    "Mumbai, India", "Full-Time",
		    "Roles & Responsibilities: Manage HANA database, optimize queries, and ensure data security.",
		    "Experience: 6+ years"));

		jobMap.put("sap_abap_developer", new JobsInfo("SAP ABAP Developer", 
		    "Develops and maintains SAP applications using ABAP programming language. Requires knowledge of ABAP, SAP modules, and performance tuning.",
		    "Pune, India", "Full-Time",
		    "Roles & Responsibilities: Write ABAP code, develop custom SAP solutions, and integrate with SAP modules.",
		    "Experience: 4+ years"));

		jobMap.put("sap_scm_consultant", new JobsInfo("SAP SCM Consultant", 
		    "Specializes in SAP Supply Chain Management (SCM) module, integrating it with related technologies. Requires experience with SAP SCM, logistics, and supply chain optimization.",
		    "Delhi, India", "Full-Time",
		    "Roles & Responsibilities: Configure SAP SCM module, manage supply chain processes, and collaborate with logistics teams.",
		    "Experience: 5+ years"));


	}

	@GetMapping("/api/jobs")
	public Map<String, JobsInfo> getAllJobs() {
		return jobMap;
	}

	@GetMapping("/carrer")
	public ModelAndView contact(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("job");
		return modelAndView;

	}

	@PostMapping("/api/jobs/apply")
	public String applyForJob(@RequestParam("jobId") String jobId, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("skills") String skills,
			@RequestParam("phone") String phone, @RequestParam("resume") MultipartFile resume) {
		try {
			// Process the file or check its size here if needed
			String message = String.format(
					"Thank you for applying for the %s position. Our team will be in touch with you soon.",
					jobMap.get(jobId).getTitle());
			emailService.test(name, message, jobId, resume,phone);
			return message;
		} catch (Exception e) {
			return "Failed to process application: " + e.getMessage();
		}

	}

}
