package com.bikeRentalSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bikeRentalSystem.beans.Bike;
import com.bikeRentalSystem.beans.Booking;
import com.bikeRentalSystem.beans.Customer;

public class BookingDetailsDao {

	@Autowired
	private BikeDetailsDao bikeDetailsDao;

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setBikeAvailableStatusToTrue(int bikeId) {
		String sql = "UPDATE BikeDetails SET available = 0 WHERE bikeId = " + bikeId;
		jdbcTemplate.update(sql);
	}

	public int bookBike(Booking booking) {
		String sql = "INSERT INTO BookingDetails (bookingId,custId,bikeId,bookedTime,branchId,returnStatus) VALUES (?, ?, ?, ?, ?,?)";
		setBikeAvailableStatusToTrue(booking.getBikeId());
		System.out.println(bikeDetailsDao.getBranchIdByBikeId(booking.getBikeId()));
		return jdbcTemplate.update(sql, booking.getBookingId(), booking.getCustId(), booking.getBikeId(),
				booking.getBookedTime(), bikeDetailsDao.getBranchIdByBikeId(booking.getBikeId()), false);

	}

	public int deleteBooking(int custId) {
		String sql = "delete from BookingDetails where custId=" + custId + "";
		return jdbcTemplate.update(sql);
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
		}

		return booking;
	}

	public Booking getBookingByCustomerId(int custId) {
		String sql = "SELECT * FROM BookingDetails WHERE custId = ?";
		RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
		Booking booking = null;

		try {
			booking = jdbcTemplate.queryForObject(sql, rowMapper, custId);
		} catch (EmptyResultDataAccessException e) {
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

	public Bike getBikeByBookingId(String bookingId) {
		String sql = "SELECT b.* FROM BookingDetails bd" + "INNER JOIN BikeDetails b ON bd.bikeId = b.bikeId"
				+ "WHERE bd.bookingId = ?";
		try {
			Bike bike = jdbcTemplate.queryForObject(sql, new Object[] { bookingId }, new RowMapper<Bike>() {
				public Bike mapRow(ResultSet rs, int rowNum) throws SQLException {
					Bike bike = new Bike();
					bike.setBikeId(rs.getInt("bikeId"));
					bike.setBikeName(rs.getString("bikeName"));
					bike.setModel(rs.getString("model"));
					bike.setManufacturedYear(rs.getInt("manufacturedYear"));
					bike.setBikeImage(rs.getBytes("bikeImage"));
					bike.setPrice(rs.getDouble("price"));
					bike.setAvailable(rs.getBoolean("available"));
					bike.setBranchId(rs.getInt("branchId"));
					return bike;
				}
			});
			return bike;
		} catch (Exception e) {
			return null;
		}

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
					int cId = customer.getCustId();
					booking.setCustId(cId);

					Bike bike = new Bike();
					bike.setBikeId(rs.getInt("bikeId"));
					int bId = bike.getBikeId();
					booking.setBikeId(bId);

					booking.setBookedTime(rs.getTimestamp("bookedTime").toLocalDateTime());

					return booking;
				}
			});
		} catch (EmptyResultDataAccessException e) {
		}

		return bookingHistory;
	}

	public List<Booking> getBookingHistoryByCustomerIdAndReturnStatus(int customerId) {
		String sql = "SELECT * FROM BookingDetails WHERE custId = ? and returnStatus = 0";
		List<Booking> bookingHistory = new ArrayList<>();

		try {
			bookingHistory = jdbcTemplate.query(sql, new Object[] { customerId }, new RowMapper<Booking>() {
				@Override
				public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
					Booking booking = new Booking();
					booking.setBookingId(rs.getString("bookingId"));

					Customer customer = new Customer();
					customer.setCustId(rs.getInt("custId"));
					int cId = customer.getCustId();
					booking.setCustId(cId);

					Bike bike = new Bike();
					bike.setBikeId(rs.getInt("bikeId"));
					int bId = bike.getBikeId();

					booking.setBikeId(bId);

					booking.setBookedTime(rs.getTimestamp("bookedTime").toLocalDateTime());

					return booking;
				}
			});
		} catch (EmptyResultDataAccessException e) {

		}

		return bookingHistory;
	}

	public int setreturnStatusAfterPayment(Booking b) {
		String sql = "Update BookingDetails set returnStatus = 1 where  bookingId = " + b.getBookingId() + "";
		return jdbcTemplate.update(sql);
	}

	public double calculateRevenueByBranchAndPeriod(int branchId, int year, int quarter, int month) {

		String sql = "SELECT SUM(paymentAmount) FROM PaymentDetails "
				+ "INNER JOIN BookingDetails ON PaymentDetails.bookingId = BookingDetails.bookingId "
				+ "WHERE BookingDetails.branchId = ? " + "AND YEAR(BookingDetails.bookedTime) = ? "
				+ "AND QUARTER(BookingDetails.bookedTime) = ? " + "AND MONTH(BookingDetails.bookedTime) = ?";

		Double revenue = jdbcTemplate.queryForObject(sql, Double.class, branchId, year, quarter, month);

		if (revenue == null) {
			revenue = 0.0;
		}

		return revenue;
	}

	public String getBookingIdByCustId(int custId) throws Exception {
		try {
			String sql = "Select branchId From BookingDetails Where custId = ?";
			return jdbcTemplate.queryForObject(sql, new Object[] { custId }, String.class);
		} catch (Exception e) {
			return null;
		}
	}

}
