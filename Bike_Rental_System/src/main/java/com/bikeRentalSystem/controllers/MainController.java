package com.bikeRentalSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bikeRentalSystem.beans.Customer;
import com.bikeRentalSystem.dao.CustomerDao;

@Controller
public class MainController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping("/customerRegistrationForm")
	public String showForm(Model m) {
		m.addAttribute("command", new Customer());
		return "customerRegistrationForm";
	}
	
	@RequestMapping(value="/login")
	public String  showLoginPage(Model m) {
		m.addAttribute(m);
		return "bikeRental";
	}
}
