package com.bikeRentalSystem.controllers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bikeRentalSystem.beans.Bike;
import com.bikeRentalSystem.beans.Booking;
import com.bikeRentalSystem.beans.Customer;
import com.bikeRentalSystem.dao.BikeDetailsDao;
import com.bikeRentalSystem.dao.BookingDetailsDao;
import com.bikeRentalSystem.dao.CustomerDao;

@Controller
public class CustomerController {

	@Autowired
	private BikeDetailsDao bikeDetailsDao;

	@Autowired
	private BookingDetailsDao bookingDetailsDao;

	@Autowired
	private CustomerDao custDao;

	@RequestMapping(value = "/veiwBikesCustomer")
	public String showCustomerPage(Model m) {

		try {

			List<Bike> list = bikeDetailsDao.getBikesByAvailability();

			m.addAttribute("list", list);
			return "veiwBikesCustomer";
		} catch (Exception e) {
			// TODO: handle exception
			return null;

		}
	}

	

	@GetMapping("/bookingConfirmation/{bookingId}")
	public String getConfirmation(@PathVariable("bookingId") String bookingId, Model model) {
		Booking booking = bookingDetailsDao.getBookingById(bookingId);

		if (booking != null) {
			model.addAttribute("bookingId", booking.getBookingId());

			Bike bike = bikeDetailsDao.getBikeById(booking.getBikeId());
			if (bike != null) {
				model.addAttribute("bikeId", bike.getBikeId());
			} else {
				model.addAttribute("bikeId", "N/A");
			}

			Customer customer = custDao.getCustomerById(booking.getCustId());
			if (customer != null) {
				model.addAttribute("custId", customer.getCustId());
			} else {
				model.addAttribute("custId", "N/A");
			}

			LocalDateTime bookedTime = booking.getBookedTime();
			if (bookedTime != null) {
				model.addAttribute("bookedTime", bookedTime.toString());
			} else {
				model.addAttribute("bookedTime", "N/A");
			}
		}

		return "bookingConfirmation";
	}

	@PostMapping("/bookBike")
	public String bookBikeDetails(@RequestParam("bikeId") int bikeId, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		int id=customer.getCustId();

		Bike bike = bikeDetailsDao.getBikeById(bikeId);
		int bId=bike.getBikeId();

		Booking booking = new Booking();
		booking.setBookingId(bookingDetailsDao.generateBookingId()); 
		booking.setBookedTime(LocalDateTime.now());
		booking.setCustId(id);
		booking.setBikeId(bId);
		booking.setReturnStatus(false);

		/* bikeDetailsDao.setBikeAvailablity(booking.getBike().getBikeId(), false); */

		bookingDetailsDao.bookBike(booking);

		return "redirect:/bookingConfirmation/" + booking.getBookingId();
	}

	@RequestMapping(value = "/returnHistory", method = RequestMethod.GET)
	public String getreturnHistory(Model model, HttpSession session) {
	    Customer customer = (Customer) session.getAttribute("customer");
	    
	    
	    List<Booking> returnHistory = bookingDetailsDao.getBookingHistoryByCustomerIdAndReturnStatus(customer.getCustId());
	    
	    
	    
	    
	    model.addAttribute("returnHistory", returnHistory);
	    
	    return "returnHistory";
	}
	@RequestMapping(value = "/bookingHistory", method = RequestMethod.GET)
	public String getBookingHistory(Model model, HttpSession session) {
	    Customer customer = (Customer) session.getAttribute("customer");
	    
	    List<Booking> bookingHistory = bookingDetailsDao.getBookingHistoryByCustomerId(customer.getCustId());
	    
	    model.addAttribute("bookingHistory", bookingHistory);
	    
	    return "bookingHistory";
	}
	
	@RequestMapping(value = "/payment/{bookingId}", method = RequestMethod.POST)
	public String payment(@RequestParam("bookingId") String bookingId, Model model) {
	    
		 System.out.println("test: "+bookingId);
	    Booking booking = bookingDetailsDao.getBookingById(bookingId);
	    Bike bike = bikeDetailsDao.getBikeById(booking.getBikeId());
	    bike.setAvailable(true);
	    System.out.println(bike);
	    double hourlyRate = bike.getPrice();
	    LocalDateTime bookedTime = booking.getBookedTime();
	    LocalDateTime currentTime = LocalDateTime.now();
	    long duration = Duration.between(bookedTime, currentTime).toHours();
	    double paymentAmount = duration * hourlyRate;
	    
	    model.addAttribute("booking", booking);
	    model.addAttribute("bike", bike);
	    model.addAttribute("duration", duration);
	    model.addAttribute("paymentAmount", paymentAmount);
	    
	    return "payment";
	}



}
