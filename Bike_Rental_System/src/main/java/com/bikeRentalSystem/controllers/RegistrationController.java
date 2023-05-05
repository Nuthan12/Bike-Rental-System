package com.bikeRentalSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bikeRentalSystem.beans.Customer;
import com.bikeRentalSystem.dao.CustomerDao;

@Controller
public class RegistrationController {
	
	
	@Autowired
	private CustomerDao custDao;
	
	@RequestMapping("/customerRegistrationForm")
	public String showForm(Model m) {
		m.addAttribute("command", new Customer());
		return "customerRegistrationForm";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute("customer") Customer customer) {
		custDao.save(customer);
		return "redirect:/veiwCustomers";
	}
	
	@RequestMapping("/veiwCustomers")
	public String veiwCustomer(Model m) {
		 List<Customer> list=custDao.getCustomers();    
	     m.addAttribute("list",list);  
	     return "veiwCustomers";
	}
	
	@RequestMapping(value="editCustomer/{cust_Id}")
	public String editCustomer(@PathVariable int cust_Id,Model m) {
		Customer customer=custDao.getCustomerById(cust_Id);
		m.addAttribute("command", customer);
		return "customerEditForm";
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public String editsave(@ModelAttribute("customer")Customer customer) {
		custDao.update(customer);
		return "redirect:/veiwCustomers";
	}
	@RequestMapping(value="/deleteCustomer/{cust_Id}",method=RequestMethod.POST)
	public String delete(@PathVariable int cust_Id) {
		custDao.delete(cust_Id);
		return "redirect:/veiwCustomers";
	}
}
