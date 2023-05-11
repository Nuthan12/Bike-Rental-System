package com.bikeRentalSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bikeRentalSystem.beans.Bike;
import com.bikeRentalSystem.beans.Customer;
import com.bikeRentalSystem.dao.BikeDetailsDao;

@Controller
public class CustomerController {
	
	@Autowired
	private BikeDetailsDao bikeDetailsDao;
	
	@RequestMapping(value="/veiwBikesCustomer")
	public String  showLoginPage(Model m) {
		m.addAttribute(m);
		return "veiwBikesCustomer";
	}
	
	@RequestMapping(value="bookBike/{bikeId}")
	public String bookBike(@PathVariable int bikeId,Model m) {
		Bike bike=bikeDetailsDao.getBikeById(bikeId);
		m.addAttribute("command", bike);
		return "bikeBookingForm";
	}
	
}
