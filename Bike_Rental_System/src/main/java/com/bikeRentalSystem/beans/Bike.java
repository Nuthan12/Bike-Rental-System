package com.bikeRentalSystem.beans;

public class Bike {
	
	private int bikeId;
	private String bikeName;
	private String model;
	private int manufacturedYear;
	private byte[] bikeImage;
	
	
	
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public byte[] getBikeImage() {
		return bikeImage;
	}
	public void setBikeImage(byte[] bikeImage) {
		this.bikeImage = bikeImage;
	}
	public int getBikeId() {
		return bikeId;
	}
	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
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
	public Bike(int bikeId, String bikeName, String model, int manufacturedYear) {
		super();
		this.bikeId = bikeId;
		this.bikeName = bikeName;
		this.model = model;
		this.manufacturedYear = manufacturedYear;
	}
	public Bike(String bikeName, String model, int manufacturedYear) {
		super();
		this.bikeName = bikeName;
		this.model = model;
		this.manufacturedYear = manufacturedYear;
	}
	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
