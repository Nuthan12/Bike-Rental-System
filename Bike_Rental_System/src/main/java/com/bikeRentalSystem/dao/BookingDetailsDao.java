package com.bikeRentalSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bikeRentalSystem.beans.Bike;
import com.bikeRentalSystem.beans.Booking;
import com.bikeRentalSystem.beans.Customer;

public class BookingDetailsDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setBikeAvailableStatus(int bikeId) {
		String sql = "UPDATE BikeDetails SET available = 0 WHERE bikeId = " + bikeId;
		jdbcTemplate.update(sql);
	}

	public int bookBike(Booking booking) {
		String sql = "INSERT INTO BookingDetails (bookingId,custId,bikeId,bookedTime,branchId) VALUES (?, ?, ?, ?, ?)";
		setBikeAvailableStatus(booking.getBike().getBikeId());
		return jdbcTemplate.update(sql, booking.getBookingId(), booking.getCustomer().getCustId(),
				booking.getBike().getBikeId(), booking.getBookedTime(), booking.getBike().getBranchId());

	}

	public String generateBookingId() {
		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
		String timestampString = now.format(formatter);

		int random = new Random().nextInt(9000) + 1000;

		String bookingId = timestampString + random;

		return bookingId;
	}

	public Booking getBookingById(String bookingId) {
		String sql = "SELECT * FROM BookingDetails WHERE bookingId = ?";
		RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
		Booking booking = null;

		try {
			booking = jdbcTemplate.queryForObject(sql, rowMapper, bookingId);
		} catch (EmptyResultDataAccessException e) {
			// Handle empty result, e.g., log an error or throw a custom exception
		}

		return booking;
	}

	public List<Booking> getBookings() {
		return jdbcTemplate.query("select * from BookingDetails", new RowMapper<Booking>() {
			public Booking mapRow(ResultSet rs, int row) throws SQLException {
				Booking b = new Booking();
				b.setBookingId(rs.getString(1));

				return b;
			}
		});
	}

	public List<Booking> getBookingHistoryByCustomerId(int customerId) {
		String sql = "SELECT * FROM BookingDetails WHERE custId = ?";
		List<Booking> bookingHistory = new ArrayList<>();

		try {
			bookingHistory = jdbcTemplate.query(sql, new Object[] { customerId }, new RowMapper<Booking>() {
				@Override
				public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
					Booking booking = new Booking();
					booking.setBookingId(rs.getString("bookingId"));

					Customer customer = new Customer();
					customer.setCustId(rs.getInt("custId"));
					// Set other properties of Customer if needed
					booking.setCustomer(customer);

					Bike bike = new Bike();
					bike.setBikeId(rs.getInt("bikeId"));
					// Set other properties of Bike if needed
					booking.setBike(bike);

					booking.setBookedTime(rs.getTimestamp("bookedTime").toLocalDateTime());

					// Set other properties as needed

					return booking;
				}
			});
		} catch (EmptyResultDataAccessException e) {
			// Handle empty result if needed
		}

		return bookingHistory;
	}

}
