package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.service.IWishMessageService;

@Controller
public class WishMessageGenerator {

	@Autowired
	private IWishMessageService service;

	@RequestMapping("/")
	public String showHome() {
		return "home"; // Maps to /WEB-INF/pages/home.jsp
	}

	
	  @RequestMapping("/wish") 
	  public ModelAndView generateMessage() { //use service 
		  String result=service.generateWishMessage(); //retunr MAV
	  
	  ModelAndView mav= new ModelAndView();
	  mav.addObject("wMsg",result);//like this we can add no.of model attributes 
	  mav.setViewName("display"); 
	  return  mav;
	  
	  
	 // return new ModelAndView("display","wMsg",result); //here we can add only onemodel attribute
	  }
	 

	/*
	 * @RequestMapping("/wish") 
	 * public String generateMessage(ModelMap map) {
	 * System.out.println("SharedMemoryWishMessage()"); 
	 * //use service String
	 * result=service.generateWishMessage(); 
	 * map.addAttribute("wMsg",result);
	 * //return logical view name return "display"; }
	 */
	
	/*
	 * @RequestMapping("/wish") 
	 * public String generateMessage(ModelMap map) {
	 * System.out.println("sharedMemory obj class name="+map.getClass()); 
	 * //use service 
	 * String result=service.generateWishMessage(); 
	 * map.addAttribute("wMsg",
	 * result); //return Logical View Name return "display"; }
	 */
	/*
	 * @RequestMapping("/wish") public String generateMessage(Map<String,Object>map)
	 * { System.out.println("sharedMemory obj class name="+map.getClass()); //use
	 * service String result=service.generateWishMessage(); map.put("wMsg", result);
	 * //return Logical View Name return "display"; //this is the best way of
	 * handler method }
	 */
	

	@RequestMapping("/wish")
	public String generateMessage(Model model) {
		System.out.println("sharedMemory obj class name="+model.getClass());
		//use service
		String result=service.generateWishMessage();
		model.addAttribute("wMsg", result);
		//return Logical View Name
		return "display";                             //this is the best way of handler method 
	}
	
	
	
	
	
	
}
