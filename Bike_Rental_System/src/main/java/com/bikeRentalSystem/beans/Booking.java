package com.bikeRentalSystem.beans;

import java.time.LocalDateTime;

public class Booking {

	private String bookingId;
	private LocalDateTime bookedTime;
	private int custId;
	private int bikeId;
	private boolean returnStatus;
	
	
	public boolean isReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(boolean returnStatus) {
		this.returnStatus = returnStatus;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(LocalDateTime bookedTime, int custId, int bikeId) {
		super();
		this.bookedTime = bookedTime;
		this.custId = custId;
		this.bikeId = bikeId;
	}
	public Booking(String bookingId, LocalDateTime bookedTime, int custId, int bikeId) {
		super();
		this.bookingId = bookingId;
		this.bookedTime = bookedTime;
		this.custId = custId;
		this.bikeId = bikeId;
	}
	
	public Booking(String bookingId, LocalDateTime bookedTime, int custId, int bikeId, boolean returnStatus) {
		super();
		this.bookingId = bookingId;
		this.bookedTime = bookedTime;
		this.custId = custId;
		this.bikeId = bikeId;
		this.returnStatus = returnStatus;
	}
	
	public Booking(LocalDateTime bookedTime, int custId, int bikeId, boolean returnStatus) {
		super();
		this.bookedTime = bookedTime;
		this.custId = custId;
		this.bikeId = bikeId;
		this.returnStatus = returnStatus;
	}
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
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getBikeId() {
		return bikeId;
	}
	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	
	

}
