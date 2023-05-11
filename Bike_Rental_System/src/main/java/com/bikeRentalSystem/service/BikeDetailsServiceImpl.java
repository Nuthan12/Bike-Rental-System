package com.bikeRentalSystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bikeRentalSystem.beans.Bike;

public class BikeDetailsServiceImpl implements BikeDetailsService {
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Bike b){    
	    String sql="insert into BikeDetails(bikeName,model,maufacturedYear) values('"+b.getBikeName()+"','"+b.getModel()+"',"+b.getManufacturedYear()+","+b.getBikeImage()+"')";    
	    return jdbcTemplate.update(sql);    
	}    
	@Override
	public int update(Bike b){ 
			String sql="update BikeDetails set bikeName='"+b.getBikeName()+"', model='"+b.getModel()+"', manufacturedYear='"+b.getManufacturedYear()+"',bikeImage='"+b.getBikeImage()+"' where bikeId="+b.getBikeId()+"";    
		    return jdbcTemplate.update(sql); 
	}    
	@Override
	public int delete(int bikeId){    
	    String sql="delete from BikeDetails where bikeId="+bikeId+"";    
	    return jdbcTemplate.update(sql);    
	}    
	@Override
	public Bike getBikeById(int bikeId){    
	    String sql="select * from BikeDetails where bikeId=?";    
	    return jdbcTemplate.queryForObject(sql, new Object[]{bikeId},new BeanPropertyRowMapper<Bike>(Bike.class));    
	}
	
	@Override
	public Bike getBikeByName(String bikeName) {
		String sql="select * from BikeDetails where bikeName=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {bikeName}, new BeanPropertyRowMapper<Bike>(Bike.class));
	}
	
	@Override
	public List<Bike> getBikes()
	{
		return jdbcTemplate.query("select * from BikeDetails",new RowMapper<Bike>(){    
	        public Bike mapRow(ResultSet rs, int row) throws SQLException {    
	            Bike b=new Bike();    
	            b.setBikeId(rs.getInt(1));    
	            b.setBikeName(rs.getString(2));
	            b.setModel(rs.getString(3));
	            b.setManufacturedYear(rs.getInt(4));
	            b.setBikeImage(rs.getBytes(5));
	            return b;    
	        }    
		});
	}
	
	
}
