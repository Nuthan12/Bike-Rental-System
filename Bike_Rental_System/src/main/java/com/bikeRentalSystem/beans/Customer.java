package com.bikeRentalSystem.beans;

public class Customer {
	
	
	private int custId;
	private String custName;
	private String custMail;
	private Long custPhone;
	private String dlNumber;
	private int age;
	private String password;
	private String confirmPassword;
	private String authorities;
	public String getAuthorities() {
		return authorities;
	}
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustMail() {
		return custMail;
	}
	public void setCustMail(String custMail) {
		this.custMail = custMail;
	}
	public Long getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(Long custPhone) {
		this.custPhone = custPhone;
	}
	public String getDlNumber() {
		return dlNumber;
	}
	public void setDlNumber(String dlNumber) {
		this.dlNumber = dlNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int custId, String custName, String custMail, Long custPhone, String dlNumber, int age,
			String password, String authorities) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custMail = custMail;
		this.custPhone = custPhone;
		this.dlNumber = dlNumber;
		this.age = age;
		this.password = password;
		this.authorities = authorities;
	}
	public Customer(String custName, String custMail, Long custPhone, String dlNumber, int age, String password,
			 String authorities) {
		super();
		this.custName = custName;
		this.custMail = custMail;
		this.custPhone = custPhone;
		this.dlNumber = dlNumber;
		this.age = age;
		this.password = password;
		this.authorities = authorities;
	}
	
	
	
	
}
