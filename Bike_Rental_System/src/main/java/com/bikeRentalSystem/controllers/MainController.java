package com.bikeRentalSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bikeRentalSystem.beans.Bike;
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
	
	@RequestMapping(value="/loginPage")
	public String  showLoginPage(Model m) {
		m.addAttribute(m);
		return "loginPage";
	}
	
	@RequestMapping(value="/customerHome")
	public String  showCustomerHome(Model m) {
		m.addAttribute(m);
		return "customerHome";
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.POST)
	public ModelAndView loginUser(@Validated @ModelAttribute("customer") Customer customer, BindingResult result) {
	    ModelAndView modelAndView = new ModelAndView();

	    if (result.hasErrors()) {
	        modelAndView.setViewName("loginPage");
	    } else {
	        // perform authentication and redirect to home page
	        modelAndView.setViewName("redirect:/index");
	    }

	    return modelAndView;
	}
	
	@RequestMapping("/registerBikes")
	public String showBikeForm(Model m) {
		m.addAttribute("command", new Bike());
		return "registerBikes";
	}
	
}
