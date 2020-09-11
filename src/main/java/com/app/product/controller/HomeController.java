package com.app.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String  welcomeHome() {
		
		return "Welcome to Home";
	}
	
}
