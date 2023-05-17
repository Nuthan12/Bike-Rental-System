package com.bikeRentalSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionHandlerController {
	
	
	@RequestMapping("/deleteException")
	public String deleteException(Model m) {
		
		return "deleteException";
	}
	@RequestMapping(value="/exceptionHandler",method = RequestMethod.GET)
	public String handleException(Model m) {
		
		return "exceptionHandler";
	}
}
