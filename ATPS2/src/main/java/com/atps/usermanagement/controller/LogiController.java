package com.atps.usermanagement.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atps.usermanagement.constants.AppConstants;
import com.atps.usermanagement.domain.UserDomain;
import com.atps.usermanagement.service.UserService;

@Controller
/**
 * this is the controller class for login functionality
 * @author user
 *
 */
public class LogiController {
	
	/**
	 * injecting service class object
	 */
    @Autowired
	UserService service;
    
    private static Logger LOGGER = LogManager.getLogger(LogiController.class);
	
	/**
	 * this method is used to load the login page 
	 * @param model
	 * @return Login
	 */
	@RequestMapping("/login")
	public String loadForm(Model model) {
		LOGGER.info("************loadForm method of LogiController execution started************");
		UserDomain domain=new UserDomain();
		model.addAttribute("domain",domain);
		LOGGER.info("************loadForm method of LogiController execution ended****************");
		return AppConstants.LOGIN;//Login
		
	}
	
	@RequestMapping("/loginPOST")
	public String validateLogIn(Model model,@ModelAttribute("domain")UserDomain domain) {
		LOGGER.info("************validateLogIn of LogiController execution started***********");
		String msg=service.validateLogIn(domain);
			if(msg=="success") {
				LOGGER.info("************if block in validateLogIn method executed*********");
				model.addAttribute("name",domain.getFirstName());
			return "forward:/home";//Home
			}
			else {
				LOGGER.info("************else block in validateLogIn method executed*********");
				model.addAttribute("domain",domain);
				model.addAttribute("msg","invalid Email/password");
				return AppConstants.LOGIN; //Login
			}
	}
}
