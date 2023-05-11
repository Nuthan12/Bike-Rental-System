package com.bikeRentalSystem.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bikeRentalSystem.beans.Customer;
import com.bikeRentalSystem.dao.CustomerDao;

public class CustomerServiceImpl implements UserDetailsService, CustomerService {
	
	 @Autowired
	    private CustomerDao custDao;
	 
	 private UserDetails userDetails; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer=custDao.getCustomerByName(username);
		if(customer==null) {
			throw new UsernameNotFoundException("Invalid UserName or Password..");
		}
		return new org.springframework.security.core.userdetails.User(customer.getCustName(),
                customer.getPassword(), getAuthorities(customer));
		
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Customer customer) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (customer.getAuthorities().equals("admin")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorities;
    }

}
