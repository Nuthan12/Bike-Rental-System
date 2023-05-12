package com.bikeRentalSystem.controllers;

import java.util.List;

import javax.net.ssl.SSLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bikeRentalSystem.beans.Bike;
import com.bikeRentalSystem.dao.BikeDetailsDao;

@Controller
public class BikeController {
	
	
	@Autowired
	private BikeDetailsDao bikeDetailsDao;
	
	@RequestMapping("/registerBikes")
	public String showBikeForm(Model m) {
		m.addAttribute("command", new Bike());
		return "registerBikes";
	}
	
	@RequestMapping(value="/saveBike",method=RequestMethod.POST)
	public String saveBike(@ModelAttribute("bike") Bike bike) {
		if(bike.isAvailable()==true) {	
		bikeDetailsDao.saveBikeAvaialble(bike);
			return "redirect:/veiwBikes";
	}
		else {
			bikeDetailsDao.saveBikeNotAvaialble(bike);
			return "redirect:/veiwBikes";
		}
	}
	
	@RequestMapping(value="/veiwBikes",method=RequestMethod.GET)
	public String veiwBike(Model m) throws SSLException{
		try {
		 List<Bike> list=bikeDetailsDao.getBikes();    
		
	     m.addAttribute("list",list);  
	     return "veiwBikes";
	     }
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@RequestMapping(value="editBike/{bikeId}")
	public String editBike(@PathVariable int bikeId,Model m) {
		Bike bike=bikeDetailsDao.getBikeById(bikeId);
		m.addAttribute("command", bike);
		return "bikeEditForm";
	}
	
	@RequestMapping(value="/editsaveBike",method = RequestMethod.POST)
	public String editsaveBike(@ModelAttribute("bike")Bike bike) {
		if(bike.isAvailable()==true) {
		bikeDetailsDao.updateBikeAvailable(bike);
		return "redirect:/veiwBikes";
	}
	else {
		bikeDetailsDao.updateBikeNotAvailable(bike);
		return "redirect:/veiwBikes";
		
	}
		
	}
	@RequestMapping(value="/deleteBike/{bikeId}",method=RequestMethod.GET)
	public String deleteBike(@PathVariable int bikeId) {
		bikeDetailsDao.deleteBike(bikeId);
		return "redirect:/veiwBikes";
	}
	
	@RequestMapping(value="/availableBikes",method=RequestMethod.GET)
	public String availableBikes(Model m) throws SSLException{
		try {
		 List<Bike> list=bikeDetailsDao.getBikes();    
		
	     m.addAttribute("list",list);  
	     return "availableBikes";
	     }
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
}
