package com.bikeRentalSystem.dao;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bikeRentalSystem.beans.Payment;

public class PaymentDetailsDao {
	
	

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int save(Payment p){    
	    String sql="insert into PaymentDetails(bookingId,branchId,paymentTime,paymentAmount) values('"+p.getBookingId()+"','"+p.getBranchId()+"','"+LocalDateTime.now()+"','"+p.getPaymentAmount()+"')";    
	    return jdbcTemplate.update(sql);    
	}
	
	public int deletePayment(String bookingId) {
		String sql = "delete from PaymentDetails where bookingId=" + bookingId + "";
		return jdbcTemplate.update(sql);
	}
	
	
}
