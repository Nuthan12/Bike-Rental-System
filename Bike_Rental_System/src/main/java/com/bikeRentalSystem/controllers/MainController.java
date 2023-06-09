package com.bikeRentalSystem.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value="/loginPage", method=RequestMethod.GET)
	public String  showLoginPage(ModelMap m) {
		m.addAttribute("customer",new Customer());
		return "loginPage";
	}
	
	@RequestMapping(value="/customerHome")
	public String  showCustomerHome(Model m) {
		m.addAttribute(m);
		return "customerHome";
	}
	

	
	@RequestMapping(value = "/loginPage", method = RequestMethod.POST)
	public String loginUser(@Validated @ModelAttribute("customer") Customer customer, 
	        BindingResult result,
	        ModelMap m,
	        Model model,
	        HttpSession httpSession) {
	    try {
	        String customerMail = customer.getCustMail();
	        String custPassword = customer.getPassword();

	        System.out.printf(customerMail, custPassword);
	        Customer cust = customerDao.getCustomerByMailAndPassword(customerMail, custPassword);
	        if (cust != null) {
	            httpSession.setAttribute("customer", cust);
	            if (cust.getAuthorities().equals("user")) {
	                return "customerHome";
	            } else if (cust.getAuthorities().equals("admin")) {
	                return "adminHome";
	            } else {
	                model.addAttribute("error", "Invalid Email or Password");
	                return "loginPage";
	            }
	        } else {
	            model.addAttribute("error", "Invalid Email or Password");
	            return "loginPage";
	        }
	    } catch (Exception e) {
	        model.addAttribute("error", "An error occurred during login. Please Check Your Email and Password");
	        return "loginPage";
	    }
	}
	
	
	
}
