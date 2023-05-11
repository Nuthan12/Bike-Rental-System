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
	
	private static String USER_AUTHORITY = "user";


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int save(Customer c){    
	    String sql="insert into CustomerDetails(custName,custMail,custPhone,dlNumber,age,password,authorities) values('"+c.getCustName()+"','"+c.getCustMail()+"',"+c.getCustPhone()+",'"+c.getDlNumber()+"','"+c.getAge()+"','"+c.getPassword()+"','"+USER_AUTHORITY+"')";    
	    return jdbcTemplate.update(sql);    
	}    
	public int update(Customer c){ 
		if(c.getPassword()==c.getConfirmPassword()) {
			String sql="update CustomerDetails set custName='"+c.getCustName()+"', custMail='"+c.getCustMail()+"', custPhone='"+c.getCustPhone()+"', dlNumber='"+c.getDlNumber()+"',age='"+c.getAge()+"',password='"+c.getPassword()+"',authorities='"+USER_AUTHORITY+"' where custId="+c.getCustId()+"";    
		    return jdbcTemplate.update(sql); 
		}
		else {
			return 0;
		}
		  
	}    
	public int delete(int custId){    
	    String sql="delete from CustomerDetails where custId="+custId+"";    
	    return jdbcTemplate.update(sql);    
	}    
	public Customer getCustomerById(int custId){    
	    String sql="select * from CustomerDetails where custId=?";    
	    return jdbcTemplate.queryForObject(sql, new Object[]{custId},new BeanPropertyRowMapper<Customer>(Customer.class));    
	}
	
	public Customer getCustomerByName(String custName) {
		String sql="select * from CustomerDetails where custName=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {custName}, new BeanPropertyRowMapper<Customer>(Customer.class));
	}
	
	public Customer getCustomerByMailAndPassword(String custMail,String password) {
		String sql="select * from CustomerDetails where custMail=? AND password=?";
		RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<Customer>(Customer.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, custMail,password);
	}
	
	public boolean checkPasswords(String password,String confirmPassword) {
		if(password==confirmPassword) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Customer> getCustomers()
	{
		return jdbcTemplate.query("select * from CustomerDetails",new RowMapper<Customer>(){    
	        public Customer mapRow(ResultSet rs, int row) throws SQLException {    
	            Customer c=new Customer();    
	            c.setCustId(rs.getInt(1));    
	            c.setCustName(rs.getString(2));    
	            c.setCustMail(rs.getString(3));    
	            c.setCustPhone(rs.getLong(4));
	            c.setDlNumber(rs.getString(5));
	            c.setAge(rs.getInt(6));
	            c.setPassword(rs.getString(7));
	            c.setAuthorities(rs.getString(8));
	            return c;    
	        }    
		});
	}
	
	
	
}
