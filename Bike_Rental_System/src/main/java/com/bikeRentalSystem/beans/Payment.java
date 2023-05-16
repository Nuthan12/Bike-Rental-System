package com.bikeRentalSystem.beans;

import java.time.LocalDateTime;

public class Payment {
	
	private int paymentId;
	private String bookingId;
	private int branchId;
	private double paymentAmount;
	private LocalDateTime paymentTime;
	
	
	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public Payment(int paymentId, String bookingId,int branchId, double paymentAmount, LocalDateTime paymentTime) {
		super();
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.branchId=branchId;
		this.paymentAmount = paymentAmount;
		this.paymentTime = paymentTime;
	}
	public Payment(String bookingId,int branchId, double paymentAmount, LocalDateTime paymentTime) {
		super();
		this.bookingId = bookingId;
		this.branchId=branchId;
		this.paymentAmount = paymentAmount;
		this.paymentTime = paymentTime;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
