package com.bikeRentalSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bikeRentalSystem.beans.Bike;
import com.bikeRentalSystem.beans.Customer;
import com.bikeRentalSystem.dao.BikeDetailsDao;
import com.bikeRentalSystem.service.BikeDetailsServiceImpl;

@Controller
public class BikeController {
	
	
	@Autowired
	private BikeDetailsDao bikeDetailsDao;
	
	@RequestMapping(value="/saveBike",method=RequestMethod.POST)
	public String saveBike(@ModelAttribute("bike") Bike bike) {
			bikeDetailsDao.saveBike(bike);
			return "redirect:/veiwBikes";
	}
	
	@RequestMapping(value="/veiwBikes",method=RequestMethod.GET)
	public String veiwBike(Model m) {
		 List<Bike> list=bikeDetailsDao.getBikes();    
	     m.addAttribute("list",list);  
	     return "veiwBikes";
	}
	
	@RequestMapping(value="editBike/{bikeId}")
	public String editBike(@PathVariable int bikeId,Model m) {
		Bike bike=bikeDetailsDao.getBikeById(bikeId);
		m.addAttribute("command", bike);
		return "bikeEditForm";
	}
	
	@RequestMapping(value="/editsaveBike",method = RequestMethod.POST)
	public String editsaveBike(@ModelAttribute("bike")Bike bike) {
		bikeDetailsDao.updateBike(bike);
		return "redirect:/veiwBikes";
	}
	@RequestMapping(value="/deleteBike/{bikeId}",method=RequestMethod.GET)
	public String deleteBike(@PathVariable int bikeId) {
		bikeDetailsDao.deleteBike(bikeId);
		return "redirect:/veiwBikes";
	}
}
