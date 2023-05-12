package com.bikeRentalSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bikeRentalSystem.beans.Bike;
import com.bikeRentalSystem.beans.Booking;
import com.bikeRentalSystem.dao.BikeDetailsDao;
import com.bikeRentalSystem.dao.BookingDetailsDao;

@Controller
public class CustomerController {

	@Autowired
	private BikeDetailsDao bikeDetailsDao;

	@Autowired
	private BookingDetailsDao bookingDetailsDao;

	@RequestMapping(value = "/veiwBikesCustomer")
	public String showLoginPage(Model m) {
		
		try {
			
			List<Bike> list = bikeDetailsDao.getBikesByAvailability();

			m.addAttribute("list", list);
			return "veiwBikesCustomer";
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		
		}
	}

	@RequestMapping(value = "bookBike/{bikeId}")
	public String bookBike(@PathVariable int bikeId, Model m) {
		Bike bike = bikeDetailsDao.getBikeById(bikeId);
		m.addAttribute("command", bike);
		return "bikeBookingForm";
	}

	@RequestMapping(value="/bookBike",method=RequestMethod.POST)
	public ResponseEntity<String> bookBike(@RequestBody Booking booking) {
		int bookingId = bookingDetailsDao.bookBike(booking);
		if (bookingId != -1) {
			return ResponseEntity.ok("Booking successful. Booking ID: " + bookingId);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to book the bike.");
		}
	}

}
