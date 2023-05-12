package com.bikeRentalSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bikeRentalSystem.beans.Branch;
import com.bikeRentalSystem.dao.BranchDetailsDao;

@Controller
public class BranchController {
	
	
	@Autowired
	private BranchDetailsDao branchDetailsDao;
	
	
	@RequestMapping("/registerBranch")
	public String showBranchForm(Model m) {
		m.addAttribute("command", new Branch());
		return "registerBranch";
	}
	
	@RequestMapping(value="/branchSearch")
	public String  searchBranches(@RequestParam("query")String query,Model m) {
		 List<Branch> branches = branchDetailsDao.searchBranches(query);
		m.addAttribute("list", branches);
		return "veiwBranches";
	}
	
	
	@RequestMapping(value="/veiwBranches")
	public String  veiwBranches(Model m) {
		 List<Branch> branches = branchDetailsDao.getBranches();
		m.addAttribute("list", branches);
		return "veiwBranches";
	}
	
	@RequestMapping(value="/saveBranch",method=RequestMethod.POST)
	public String saveBranch(@ModelAttribute("branch") Branch branch) {
		branchDetailsDao.saveBranch(branch);
		return "redirect:/veiwBranches";
	}
	
	@RequestMapping("/editBranch/{branchId}")
	public String editBranch(@PathVariable int branchId,Model m) {
		Branch branch=branchDetailsDao.getBranchById(branchId);
		m.addAttribute("command", branch);
		return "branchEditForm";
	}
	
	@RequestMapping(value="/editSaveBranch",method = RequestMethod.POST)
	public String editSaveBranch(@ModelAttribute("branch")Branch branch) {
		branchDetailsDao.updateBranch(branch);
		return "redirect:/veiwBranches";
	}
	@RequestMapping(value="/deleteBranch/{branchId}",method=RequestMethod.GET)
	public String deleteBranch(@PathVariable int branchId) {
		branchDetailsDao.deleteBranch(branchId);
		return "redirect:/veiwBranches";
	}
	
	
}
