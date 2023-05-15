package com.bikeRentalSystem.controllers;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bikeRentalSystem.beans.Booking;
import com.bikeRentalSystem.dao.BookingDetailsDao;

@Controller
public class PaymentController {
	
	@Autowired
	private BookingDetailsDao bookingDetailsDao;
	
	
	@PostMapping("/processPayment")
    public String processPayment(@RequestParam("bookingId") String bookingId,
                                 @RequestParam("cardNumber") String cardNumber,
                                 @RequestParam("expiryDate") String expiryDate,
                                 @RequestParam("cvv") String cvv,
                                 Model model) {
        

        Booking booking = bookingDetailsDao.getBookingById(bookingId);
        
        double hourlyRate = booking.getBike().getPrice();
        LocalDateTime bookedTime = booking.getBookedTime();
        LocalDateTime returnTime = LocalDateTime.now(); 
        
        long duration = Duration.between(bookedTime, returnTime).toHours();
        double paymentAmount = hourlyRate * duration;
        
        model.addAttribute("booking", booking);
        model.addAttribute("paymentAmount", paymentAmount);
        
        return "paymentConfirmation";
    }
}
