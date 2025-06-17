package com.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	
	
	@RequestMapping(value="/report" ,method=RequestMethod.GET)
	
	public String showReport(Map<String,Object>map) {
		System.out.println("TestController.showRepost");
		return "display";
		
	}

	
	@RequestMapping(value="/report",method=RequestMethod.POST)
	public String showReport1(Map<String,Object>map) {
		System.out.println("TestController.showreport1");
		return "display1";
		
	}
	
	
	
}
