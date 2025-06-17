package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	
	@GetMapping("/")
	public String homePage() {
		return "home";
		
	}
	@GetMapping("/abouturl")
	public String aboutPage() {
		return "about";
	}
 @GetMapping("/loginpage")
 public String loginPage() {
	 return "login";
 }
}
