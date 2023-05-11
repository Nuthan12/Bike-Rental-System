package com.bikeRentalSystem.beans;

public class Branch {
	
	private int branchId;
	private String branchName;
	private String branchAddress;
	private long branchPinCode;
	
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public long getBranchPinCode() {
		return branchPinCode;
	}
	public void setBranchPinCode(long branchPinCode) {
		this.branchPinCode = branchPinCode;
	}
	
	
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	public Branch(String branchName, String branchAddress, long branchPinCode) {
		super();
		this.branchName = branchName;
		this.branchAddress = branchAddress;
		this.branchPinCode = branchPinCode;
	}
	public Branch(int branchId, String branchName, String branchAddress, long branchPinCode) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
		this.branchPinCode = branchPinCode;
	}
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
