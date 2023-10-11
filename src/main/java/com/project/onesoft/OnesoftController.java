package com.project.onesoft;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnesoftController {
	@GetMapping(value="/student") 
	public String get() {
		return "This is student";
		
	}
	@GetMapping(value="/trainer") 
	public String getT() {
		return "This is trainer";
	}
	@GetMapping(value="/manager") 
	public String getM() {
		return "This is Manager";
	
	}
}
