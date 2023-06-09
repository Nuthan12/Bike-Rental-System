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
import com.bikeRentalSystem.dao.BookingDetailsDao;
import com.bikeRentalSystem.dao.BranchDetailsDao;
import com.bikeRentalSystem.dao.CustomerDao;
import com.bikeRentalSystem.dao.PaymentDetailsDao;

@Controller
public class RegistrationController {

	@Autowired
	private CustomerDao custDao;

	@Autowired
	private BookingDetailsDao bookingDetailsDao;

	@Autowired
	private PaymentDetailsDao paymentDetailsDao;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("customer") Customer customer, Model m) {
		if (customer.getAge() < 18) {
			m.addAttribute("error", "You Must Be At Least 18 Years to Use this Service");
			return "redirect:/customerRegistrationForm";
		} else {
			custDao.save(customer);
			return "redirect:/thankYou";
		}
	}

	@RequestMapping("/thankYou")
	public String thankYouForm(Model m) {

		return "thankYou";
	}

	@RequestMapping(value = "/veiwCustomers", method = RequestMethod.GET)
	public String veiwCustomer(Model m) {
		List<Customer> list = custDao.getCustomers();
		m.addAttribute("list", list);
		return "veiwCustomers";
	}

	@RequestMapping(value = "editCustomer/{custId}")
	public String editCustomer(@PathVariable int custId, Model m) {
		Customer customer = custDao.getCustomerById(custId);
		m.addAttribute("command", customer);
		return "customerEditForm";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("customer") Customer customer) {
		custDao.update(customer);
		return "redirect:/veiwCustomers";
	}

	@RequestMapping(value = "/deleteCustomer/{custId}", method = RequestMethod.GET)
	public String delete(@PathVariable int custId) throws Exception {
		try {
			String bookId = bookingDetailsDao.getBookingIdByCustId(custId);
			if (bookId == null) {
				custDao.delete(custId);
				return "redirect:/veiwCustomers";
			} else {
				bookingDetailsDao.deleteBooking(custId);
				paymentDetailsDao.deletePayment(bookId);
				custDao.delete(custId);
				return "redirect:/veiwCustomers";
			}
		} catch (Exception e) {
			return "redirect:/deleteException";
		}
	}

}
