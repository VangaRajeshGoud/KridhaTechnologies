package com.tech.kridha.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

	@GetMapping("/health")
	public String health() {
		return "Application is Running";

	}

	@GetMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;

	}

	@GetMapping("/index.html")
	public ModelAndView indexhtml(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;

	}

	@GetMapping("/")
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;

	}

	@GetMapping("/about.html")
	public ModelAndView about(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("about");
		return modelAndView;

	}

	@GetMapping("/service.html")
	public ModelAndView service(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("service");
		return modelAndView;

	}

	@GetMapping("/contact.html")
	public ModelAndView contact(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contact");
		return modelAndView;

	}

	public void getClientInfo(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-Forwarded-For");
		if (ipAddress == null || ipAddress.isEmpty()) {
			ipAddress = request.getRemoteAddr();
		}
		String userAgent = request.getHeader("User-Agent");
		String location = getLocation(ipAddress);

		String finaloutput = "IP Address: " + ipAddress + "<br>" + "Browser Info: " + userAgent + "<br>" + "Location: "
				+ location;

		System.out.println(finaloutput);
	}

	private String getLocation(String ipAddress) {
		String apiKey = "82a901d3e5d656"; // Replace with your API key
		String url = "http://ipinfo.io/" + ipAddress + "/json?token=" + apiKey;

		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> response = restTemplate.getForObject(url, Map.class);

		if (response != null) {
			return response.get("city") + ", " + response.get("region") + ", " + response.get("country");
		}
		return "Location not found";
	}
}
