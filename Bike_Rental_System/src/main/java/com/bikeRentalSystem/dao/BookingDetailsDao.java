package com.bikeRentalSystem.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bikeRentalSystem.beans.Booking;

public class BookingDetailsDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * public int bookBike(Booking b) { String sql =
	 * "insert into BookingDetails(bikeId,bikeName,model,manufacturedYear,bikeImage,price,branchId,branchName,"
	 * + "branchAddress,branchPinCode,bookingDateTime) values('" + b.getBikeId() +
	 * "','" + b.getBikeName() + "','" + b.getModel() + "','" +
	 * b.getManufacturedYear() + "','" + b.getBikeImage() + "','" + b.getPrice() +
	 * "','" + b.getBranchId() + "','" + b.getBranchName() + "','" +
	 * b.getBranchAddress() + "','" + b.getBranchPinCode() + "')"; return
	 * jdbcTemplate.update(sql); }
	 */
	
	public int bookBike(Booking b) {
	    String sql = "INSERT INTO BookingDetails (bikeId, bikeName, model, manufacturedYear, bikeImage, price, branchId, branchName, branchAddress, branchPinCode, bookingDateTime) " +
	            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try {
	        return jdbcTemplate.update(sql,
	                b.getBikeId(),
	                b.getBikeName(),
	                b.getModel(),
	                b.getManufacturedYear(),
	                b.getBikeImage(),
	                b.getPrice(),
	                b.getBranchId(),
	                b.getBranchName(),
	                b.getBranchAddress(),
	                b.getBranchPinCode(),
	                b.getBookingDateTime());
	    } catch (DataAccessException e) {
	        // Handle any potential database errors
	        e.printStackTrace();
	        return -1; // or throw a custom exception
	    }
	}

}
