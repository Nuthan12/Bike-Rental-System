package com.bikeRentalSystem.dao;

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
	
	public int bookBike(Booking b) {
		String sql = "insert into BookingDetails(bikeId,bikeName,model,manufacturedYear,bikeImage,price,branchId,branchName,branchAddress,branchPinCode,localDateTime,noOfDays) values('"
				+ b.getBikeName() + "','" + b.getModel() + "','" + b.getManufacturedYear() + "','" + b.getBikeImage()
				+ "','" + b.getPrice() + "','" + b.getBranchId() + "')";
		return jdbcTemplate.update(sql);
	}
}
