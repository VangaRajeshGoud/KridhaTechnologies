package com.tech.kridha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.kridha.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
public class FormController {

	@Autowired
	EmailService emailService;

	@PostMapping("/submit")
	public String handleFormSubmission(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("phone") String phone) {
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Phone: " + phone);
		emailService.sendEmailForm(name, email, phone);
		return "We’ve received your request. Our team will be in touch soon to provide assistance";
	}

	@PostMapping("/api/signup/email")
	public ResponseEntity<String> signUp(@RequestParam("email") String email) {
		emailService.sendEmailForm("Subscribe Email", email, email);
		return new ResponseEntity<>("Email sent successfully!", HttpStatus.OK);
	}

	@PostMapping("/api/contact/submit")
	public ResponseEntity<String> submitQuery(@RequestParam String name, @RequestParam String email,
			@RequestParam String phone, @RequestParam String subject, @RequestParam String message) {
		try {
			emailService.sendEmailForm(name, email, phone, subject, message);

			return new ResponseEntity<>("Query submitted successfully! Our team will contact you shortly!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to submit query", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
