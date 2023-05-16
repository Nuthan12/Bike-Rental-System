package com.bikeRentalSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bikeRentalSystem.beans.Bike;

public class BikeDetailsDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveBikeAvaialble(Bike b) {
		b.setAvailable(true);
		
		int availableValue=b.isAvailable()?1:0;
		String sql = "insert into BikeDetails(bikeName,model,manufacturedYear,bikeImage,price,branchId,available) values('"
				+ b.getBikeName() + "','" + b.getModel() + "','" + b.getManufacturedYear() + "','" + b.getBikeImage()
				+ "','" + b.getPrice() + "','" + b.getBranchId() +"','" + availableValue + "')";
		return jdbcTemplate.update(sql);
	}
	
	public int saveBikeNotAvaialble(Bike b) {
		b.setAvailable(false);
		int availableValue=b.isAvailable()?1:0;
		String sql = "insert into BikeDetails(bikeName,model,manufacturedYear,bikeImage,price,branchId,available) values('"
				+ b.getBikeName() + "','" + b.getModel() + "','" + b.getManufacturedYear() + "','" + b.getBikeImage()
				+ "','" + b.getPrice() + "','" + b.getBranchId() +"','" + availableValue + "')";
		return jdbcTemplate.update(sql);
	}

	public int updateBikeAvailable(Bike b) {
		b.setAvailable(true);
		int availableValue=b.isAvailable()?1:0;
		String sql = "update BikeDetails set bikeName='" + b.getBikeName() + "', model='" + b.getModel()
				+ "', manufacturedYear='" + b.getManufacturedYear() + "',bikeImage='" + b.getBikeImage() + "',price='"
				+ b.getPrice() +  "',available='" + availableValue + "' where bikeId=" + b.getBikeId() + "";
		return jdbcTemplate.update(sql);
	}
	public int updateBikeNotAvailable(Bike b) {
		b.setAvailable(false);
		int availableValue=b.isAvailable()?1:0;
		String sql = "update BikeDetails set bikeName='" + b.getBikeName() + "', model='" + b.getModel()
				+ "', manufacturedYear='" + b.getManufacturedYear() + "',bikeImage='" + b.getBikeImage() + "',price='"
				+ b.getPrice() +  "',available='" + availableValue + "' where bikeId=" + b.getBikeId() + "";
		return jdbcTemplate.update(sql);
	}

	public int deleteBike(int bikeId) {
		String sql = "delete from BikeDetails where bikeId=" + bikeId + "";
		return jdbcTemplate.update(sql);
	}
	
	public int getBranchIdByBikeId(int bikeId){
		String sql="Select branchId From BikeDetails Where bikeId = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {bikeId},Integer.class);
	}

	public Bike getBikeById(int bikeId) {
		String sql = "select * from BikeDetails where bikeId=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { bikeId }, new BeanPropertyRowMapper<Bike>(Bike.class));
	}
	public Bike getBikeByAvailability() {
		String sql = "select * from BikeDetails where available=1";
		return jdbcTemplate.queryForObject(sql, new Object[] {}, new BeanPropertyRowMapper<Bike>(Bike.class));
	}

	public List<Bike> getBikesByBranchId(int branchId) {

		return jdbcTemplate.query("select * from BikeDetails", new RowMapper<Bike>() {
			public Bike mapRow(ResultSet rs, int row) throws SQLException {
				Bike b = new Bike();
				b.setBikeId(rs.getInt(1));
				b.setBikeName(rs.getString(2));
				b.setModel(rs.getString(3));
				b.setManufacturedYear(rs.getInt(4));
				b.setBikeImage(rs.getBytes(5));
				b.setPrice(rs.getDouble(6));
				b.setBranchId(rs.getInt(8));
				b.setAvailable(rs.getBoolean(7));
				return b;
			}
		});
	}
	
	public List<Bike> getBikesByAvailability() {

		return jdbcTemplate.query("select * from BikeDetails where available=true", new RowMapper<Bike>() {
			public Bike mapRow(ResultSet rs, int row) throws SQLException {
				Bike b = new Bike();
				b.setBikeId(rs.getInt(1));
				b.setBikeName(rs.getString(2));
				b.setModel(rs.getString(3));
				b.setManufacturedYear(rs.getInt(4));
				b.setBikeImage(rs.getBytes(5));
				b.setPrice(rs.getDouble(6));
				b.setBranchId(rs.getInt(8));
				
				return b;
			}
		});
	}

	public Bike getBikeByName(String bikeName) {
		String sql = "select * from BikeDetails where bikeName=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { bikeName }, new BeanPropertyRowMapper<Bike>(Bike.class));
	}

	public List<Bike> getBikes() {
		return jdbcTemplate.query("select * from BikeDetails", new RowMapper<Bike>() {
			public Bike mapRow(ResultSet rs, int row) throws SQLException {
				Bike b = new Bike();
				b.setBikeId(rs.getInt(1));
				b.setBikeName(rs.getString(2));
				b.setModel(rs.getString(3));
				b.setManufacturedYear(rs.getInt(4));
				b.setBikeImage(rs.getBytes(5));
				b.setPrice(rs.getDouble(6));
				b.setBranchId(rs.getInt(8));
				b.setAvailable(rs.getBoolean(7));
				return b;
			}
		});
	}
	
	public void setBikeAvailablity(int bikeId,boolean status) {
		Bike bike=getBikeById(bikeId);
		bike.setAvailable(status);
	}
	
	public double getHourlyRate(int bikeId) {
		Bike bike=getBikeById(bikeId);
		double price=bike.getPrice();
		return price;
	}
}
