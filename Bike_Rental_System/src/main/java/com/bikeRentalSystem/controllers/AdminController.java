package com.bikeRentalSystem.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bikeRentalSystem.beans.Booking;
import com.bikeRentalSystem.beans.Branch;
import com.bikeRentalSystem.beans.Customer;
import com.bikeRentalSystem.dao.BookingDetailsDao;
import com.bikeRentalSystem.dao.BranchDetailsDao;

@Controller
public class AdminController {
	
	@Autowired
	private BranchDetailsDao branchDetailsDao;
	
	@Autowired
	private BookingDetailsDao bookingDetailsDao;
	
	@RequestMapping(value="/adminHome")
	public String  showAdminPage(Model m) {
		m.addAttribute(m);
		return "adminHome";
	}
	
 
	@GetMapping("/revenue")
	public String getRevenue(Model model) {
	    List<Branch> branches = branchDetailsDao.getBranches();
	    model.addAttribute("branches", branches);
	    
	    return "revenue";
	}
	
	@PostMapping("/revenue")
	public String postRevenue(@RequestParam("branchId") int branchId, Model model) {
	    Branch branch = branchDetailsDao.getBranchById(branchId);
	    
	    LocalDate currentDate = LocalDate.now();
	    int currentYear = currentDate.getYear();
	    int currentQuarter = (currentDate.getMonthValue() - 1) / 3 + 1;
	    int currentMonth = currentDate.getMonthValue();
	    
	    double monthlyRevenue = bookingDetailsDao.calculateRevenueByBranchAndPeriod(branchId, currentYear, currentQuarter, currentMonth);
	    double quarterlyRevenue = bookingDetailsDao.calculateRevenueByBranchAndPeriod(branchId, currentYear, currentQuarter, 0)+monthlyRevenue; 
	    double yearlyRevenue = bookingDetailsDao.calculateRevenueByBranchAndPeriod(branchId, currentYear, 0, 0)+quarterlyRevenue; 
	    
	    model.addAttribute("branch", branch);
	    model.addAttribute("monthlyRevenue", monthlyRevenue);
	    model.addAttribute("quarterlyRevenue", quarterlyRevenue);
	    model.addAttribute("yearlyRevenue", yearlyRevenue);
	    
	    List<Branch> branches = branchDetailsDao.getBranches();
	    model.addAttribute("branches", branches);
	    
	    return "revenue";
	}
	
	@RequestMapping(value = "/bookingHistoryAdmin", method = RequestMethod.GET)
	public String getBookingHistoryAdmin(Model model) {
	    
	    
	    List<Booking> bookingHistoryAdmin = bookingDetailsDao.getBookingHistory();
	    
	    model.addAttribute("bookingHistoryAdmin", bookingHistoryAdmin);
	    
	    return "bookingHistoryAdmin";
	}


}
