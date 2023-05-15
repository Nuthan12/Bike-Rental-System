package com.bikeRentalSystem.beans;

import java.time.LocalDateTime;

public class Booking {

	private String bookingId;
	private LocalDateTime bookedTime;
	private Customer customer;
	private Bike bike;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDateTime getBookedTime() {
		return bookedTime;
	}

	public void setBookedTime(LocalDateTime bookedTime) {
		this.bookedTime = bookedTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	public Booking(String bookingId, LocalDateTime bookedTime, Customer customer, Bike bike) {
		super();
		this.bookingId = bookingId;
		this.bookedTime = bookedTime;
		this.customer = customer;
		this.bike = bike;

	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(LocalDateTime bookedTime, Customer customer, Bike bike) {
		super();
		this.bookedTime = bookedTime;
		this.customer = customer;
		this.bike = bike;

	}

}
