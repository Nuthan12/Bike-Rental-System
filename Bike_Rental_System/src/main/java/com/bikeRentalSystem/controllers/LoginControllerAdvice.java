package com.bikeRentalSystem.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoginControllerAdvice {
	@ExceptionHandler(Exception.class)
	public String handleLoginException(Exception e,Model m) {
		m.addAttribute("error", "Invalid UserName Password"+e.getMessage());
		return "loginPage";
	}
}
