package com.bikeRentalSystem.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bikeRentalSystem.beans.BookingDetails;

public class BookingDetailsDao {
	
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int bookBike(BookingDetails b) {
		String sql = "insert into BookingDetails(bikeName,model,manufacturedYear,bikeImage,price,branchId) values('"
				+ b.getBikeName() + "','" + b.getModel() + "','" + b.getManufacturedYear() + "','" + b.getBikeImage()
				+ "','" + b.getPrice() + "','" + b.getBranchId() + "')";
		return jdbcTemplate.update(sql);
	}
}
