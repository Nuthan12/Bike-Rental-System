package com.bikeRentalSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	
	@RequestMapping(value="/adminHome")
	public String  showAdminPage(Model m) {
		m.addAttribute(m);
		return "adminHome";
	}
	
//	@RequestMapping(value="/veiwCustomers")
//	public 
}
