package com.bikeRentalSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bikeRentalSystem.beans.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int save(Customer c){    
	    String sql="insert into Customer_Details(cust_Name,cust_Mail,cust_Phone,dl_Number,age) values('"+c.getCust_Name()+"','"+c.getCust_Mail()+"',"+c.getCust_Phone()+",'"+c.getDl_Number()+"','"+c.getAge()+"')";    
	    return jdbcTemplate.update(sql);    
	}    
	public int update(Customer c){    
		String sql="update Customer_Details set cust_Name='"+c.getCust_Name()+"', cust_Mail='"+c.getCust_Mail()+"', cust_Phone='"+c.getCust_Phone()+"', dl_Number='"+c.getDl_Number()+"',age='"+c.getAge()+"' where cust_Id="+c.getCust_Id()+"";    
	    return jdbcTemplate.update(sql);   
	}    
	public int delete(int cust_Id){    
	    String sql="delete from Customer_Details where cust_Id="+cust_Id+"";    
	    return jdbcTemplate.update(sql);    
	}    
	public Customer getCustomerById(int cust_Id){    
	    String sql="select * from Customer_Details where cust_Id=?";    
	    return jdbcTemplate.queryForObject(sql, new Object[]{cust_Id},new BeanPropertyRowMapper<Customer>(Customer.class));    
	}	
	
	public List<Customer> getCustomers()
	{
		return jdbcTemplate.query("select * from Customer_Details",new RowMapper<Customer>(){    
	        public Customer mapRow(ResultSet rs, int row) throws SQLException {    
	            Customer c=new Customer();    
	            c.setCust_Id(rs.getInt(1));    
	            c.setCust_Name(rs.getString(2));    
	            c.setCust_Mail(rs.getString(3));    
	            c.setCust_Phone(rs.getLong(4));
	            c.setDl_Number(rs.getString(5));
	            c.setAge(rs.getInt(6));
	            return c;    
	        }    
		});
	}
}
