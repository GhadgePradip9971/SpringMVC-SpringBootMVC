package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.model.Employee;
import com.web.service.IEmployeeService;

@Controller
@RequestMapping("/empwebapp")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/viewpage")
	public String viewHomePage(Model model) {
		/*
		 * model.addAttribute("listEmployees", service.getAllEmployees()); return
		 * "index";
		 */
	return 	findPaginated(1,model);
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_Employee";
		
	}
	@PostMapping("/saveEmp")
	public String saveEmployee(@ModelAttribute ("employee") Employee employee) {
		
		service.saveEmployee(employee);
		return "redirect:/empwebapp/viewpage";
		
		
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value="id") long id,Model model) {
		
		Employee employee=service.getEmployeeById(id);//getting the employee from service
		model.addAttribute("employee",employee);
		return "update_Employee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value="id") long id) {
		this.service.deleteEmployeeById(id);
		return "redirect:/empwebapp/viewpage";
		
		
		
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value="pageNo") int pageNo,Model model) {
		 int pageSize = 5; // Controls how many employees to display per page
		    
		    Page<Employee> page = service.findPaginated(pageNo, pageSize);
		    List<Employee> listEmployees = page.getContent();

		    model.addAttribute("currentPage", pageNo);
		    model.addAttribute("totalPages", page.getTotalPages());
		    model.addAttribute("totalItems", page.getTotalElements());
		    model.addAttribute("listEmployees", listEmployees);
		    return "index";
		
	}
	
	

}
