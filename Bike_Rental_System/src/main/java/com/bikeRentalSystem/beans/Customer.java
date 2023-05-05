package com.bikeRentalSystem.beans;

public class Customer {
	
	
	private int cust_Id;
	private String cust_Name;
	private String cust_Mail;
	private Long cust_Phone;
	private String dl_Number;
	private int age;
	public int getCust_Id() {
		return cust_Id;
	}
	public void setCust_Id(int cust_Id) {
		this.cust_Id = cust_Id;
	}
	public String getCust_Name() {
		return cust_Name;
	}
	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}
	public String getCust_Mail() {
		return cust_Mail;
	}
	public void setCust_Mail(String cust_Mail) {
		this.cust_Mail = cust_Mail;
	}
	public Long getCust_Phone() {
		return cust_Phone;
	}
	public void setCust_Phone(Long cust_Phone) {
		this.cust_Phone = cust_Phone;
	}
	public String getDl_Number() {
		return dl_Number;
	}
	public void setDl_Number(String dl_Number) {
		this.dl_Number = dl_Number;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Customer(String cust_Name, String cust_Mail, Long cust_Phone, String dL_Number, int age) {
		super();
		this.cust_Name = cust_Name;
		this.cust_Mail = cust_Mail;
		this.cust_Phone = cust_Phone;
		dl_Number = dL_Number;
		this.age = age;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int cust_Id, String cust_Name, String cust_Mail, Long cust_Phone, String dl_Number, int age) {
		super();
		this.cust_Id = cust_Id;
		this.cust_Name = cust_Name;
		this.cust_Mail = cust_Mail;
		this.cust_Phone = cust_Phone;
		this.dl_Number = dl_Number;
		this.age = age;
	}
	
	
}
