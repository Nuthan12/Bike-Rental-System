package com.bikeRentalSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bikeRentalSystem.beans.Branch;

public class BranchDetailsDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveBranch(Branch b) {

		String sql = "insert into BranchDetails(branchName,branchAddress,branchPinCode) values('" + b.getBranchName() + "','" + b.getBranchAddress() + "','"
				+ b.getBranchPinCode() + "')";
		return jdbcTemplate.update(sql);
	}

	public int updateBranch(Branch b) {

		String sql = "update BranchDetails set branchName='" + b.getBranchName() + "',branchAddress='" + b.getBranchAddress() + "', branchPinCode='"
				+ b.getBranchPinCode() + "' where branchId=" + b.getBranchId() + "";
		return jdbcTemplate.update(sql);
	}
	
	public int deleteBranch(int branchId) {
		String sql = "delete from BranchDetails where branchId=" + branchId + "";
		return jdbcTemplate.update(sql);
	}
	
	public Branch getBranchById(int branchId) {
		String sql = "select * from BranchDetails where branchId=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { branchId }, new BeanPropertyRowMapper<Branch>(Branch.class));
	}
	public Branch getBranchByName(String branchName) {
		String sql = "select * from BranchDetails where branchName=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { branchName }, new BeanPropertyRowMapper<Branch>(Branch.class));
	}
	
	public List<Branch> getBranches() {
		return jdbcTemplate.query("select * from BranchDetails", new RowMapper<Branch>() {
			public Branch mapRow(ResultSet rs, int row) throws SQLException {
				Branch b = new Branch();
				b.setBranchId(rs.getInt(1));
				b.setBranchName(rs.getString(2));
				b.setBranchAddress(rs.getString(3));
				b.setBranchPinCode(rs.getLong(4));
				return b;
			}
		});
	}
	
	public List<Branch> searchBranches(String query){
		List<Branch> searchedBranches=new ArrayList<>();
		List<Branch> allBranches=getBranches();
		
		
		for (Branch branch : allBranches) {
            if (branch.getBranchName().toLowerCase().contains(query.toLowerCase()) ||branch.getBranchAddress().toLowerCase().contains(query.toLowerCase())) {
                searchedBranches.add(branch); // Add the matching branches to the result list
            }
        }
		
		return searchedBranches;
	}
	
	
}
