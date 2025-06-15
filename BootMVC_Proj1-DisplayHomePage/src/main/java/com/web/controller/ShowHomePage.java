package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomePage {
	
    @RequestMapping("/welcome")
	public String Homepage() {
		return "home";
	}
}
