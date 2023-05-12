package com.bikeRentalSystem.beans;

import java.time.LocalDateTime;

public class Booking {
	
	private int bookingId;
	private int bikeId;
	private String bikeName;
	private String model;
	private int manufacturedYear;
	private byte[] bikeImage;
	private double price;
	private int branchId;
	private String branchName;
	private String branchAddress;
	private long branchPinCode; 
	private LocalDateTime bookingDateTime;
	
	
	
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	public long getBranchPinCode() {
		return branchPinCode;
	}
	public void setBranchPinCode(long branchPinCode) {
		this.branchPinCode = branchPinCode;
	}
	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}
	public void setBookingDateTime(LocalDateTime localDateTime) {
		this.bookingDateTime = LocalDateTime.now();
	}
	public int getBikeId() {
		return bikeId;
	}
	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getManufacturedYear() {
		return manufacturedYear;
	}
	public void setManufacturedYear(int manufacturedYear) {
		this.manufacturedYear = manufacturedYear;
	}
	public byte[] getBikeImage() {
		return bikeImage;
	}
	public void setBikeImage(byte[] bikeImage) {
		this.bikeImage = bikeImage;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	
	
	
	
	public Booking(int bikeId, String bikeName, String model, int manufacturedYear, byte[] bikeImage,
			double price, int branchId, String branchName, String branchAddress, long branchPinCode) {
		super();
		this.bikeId = bikeId;
		this.bikeName = bikeName;
		this.model = model;
		this.manufacturedYear = manufacturedYear;
		this.bikeImage = bikeImage;
		this.price = price;
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
		this.branchPinCode = branchPinCode;
		this.bookingDateTime = LocalDateTime.now();
	}
	public Booking(int bookingId, int bikeId, String bikeName, String model, int manufacturedYear,
			byte[] bikeImage, double price, int branchId, String branchName, String branchAddress, long branchPinCode) {
		super();
		this.bookingId = bookingId;
		this.bikeId = bikeId;
		this.bikeName = bikeName;
		this.model = model;
		this.manufacturedYear = manufacturedYear;
		this.bikeImage = bikeImage;
		this.price = price;
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
		this.branchPinCode = branchPinCode;
		this.bookingDateTime = LocalDateTime.now();
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
