package com.bikeRentalSystem.controllers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bikeRentalSystem.beans.Bike;
import com.bikeRentalSystem.beans.Booking;
import com.bikeRentalSystem.beans.Payment;
import com.bikeRentalSystem.dao.BikeDetailsDao;
import com.bikeRentalSystem.dao.BookingDetailsDao;
import com.bikeRentalSystem.dao.PaymentDetailsDao;

@Controller
public class PaymentController {
	
	@Autowired
	private BookingDetailsDao bookingDetailsDao;
	
	@Autowired 
	private BikeDetailsDao bikeDetailsDao;
	
	@Autowired
	private PaymentDetailsDao paymentDetailsDao;
	
	
	@PostMapping("payment/processPayment/{bookingId}")
    public String processPayment(@RequestParam("bookingId") String bookingId,
                                 @RequestParam("cardNumber") String cardNumber,
                                 @RequestParam("expiryDate") String expiryDate,
                                 @RequestParam("cvv") String cvv,
                                 Model model) {
        
		System.out.println(bookingId);
        Booking booking = bookingDetailsDao.getBookingById(bookingId);
        Bike bike=bikeDetailsDao.getBikeById(booking.getBikeId()); 
        double hourlyRate = bike.getPrice();
        LocalDateTime bookedTime = booking.getBookedTime();
        LocalDateTime returnTime = LocalDateTime.now(); 
        bikeDetailsDao.updateBikeAvailable(bike);
        bookingDetailsDao.setreturnStatusAfterPayment(booking);
        
       
        
        long duration = Duration.between(bookedTime, returnTime).toHours();
        double paymentAmount = hourlyRate * duration;
        Payment payment = new Payment();
        payment.setBookingId(bookingId);
        payment.setBranchId(bike.getBranchId()); 
        payment.setPaymentTime(LocalDateTime.now());
        payment.setPaymentAmount(paymentAmount);
        
        paymentDetailsDao.save(payment);
        
        model.addAttribute("booking", booking);
        model.addAttribute("paymentAmount", paymentAmount);
        
        return "paymentConfirmation";
    }
}
