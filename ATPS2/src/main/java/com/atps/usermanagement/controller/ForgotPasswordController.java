package com.atps.usermanagement.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atps.usermanagement.domain.UserDomain;
import com.atps.usermanagement.properties.AppProperties;
import com.atps.usermanagement.service.UserService;

@Controller
/**
 * this is the controller class for forgot password
 * @author user
 *
 */
public class ForgotPasswordController {
	/**
	 * injecting service class object to controller class
	 */
	@Autowired
	UserService service;
	
	/**
	 * injecting AppProperties object 
	 */
	@Autowired
	AppProperties properties;
	
	UserDomain domain=null;
	private static Logger LOGGER = LogManager.getLogger(UserService.class);
	/**
	 * this method is to load the ForgotPasword form
	 * sending the domain class object as a modelAttribute
	 * @param model
	 * @return  ForgotPassword
	 */
	@RequestMapping("/forgotPassword")
	public String loadForgotPasswordForm(Model model) {
		LOGGER.info("************loadForgotPasswordForm method of  ForgotPasswordController  execution started************");
		UserDomain domain=new UserDomain();
		model.addAttribute("domain",domain);
		LOGGER.info("************loadForgotPasswordForm method of  ForgotPasswordController  execution ended************");
		return "ForgotPassword";
	}
	
	@RequestMapping("/forgotPasswordPOST")
	public String sendPasswordThroughEmail(Model model,@ModelAttribute("domain")UserDomain domain) {
		LOGGER.info("************sendPasswordThroughEmail method of  ForgotPasswordController  execution started************");
		String msg=service.getPassword(domain);
        if(msg!=null)
        model.addAttribute("msg",properties.getMessages().get("EmailSuccessMessage")+" "+domain.getEmail());
        else
        	model.addAttribute("msg",properties.getMessages().get("EmailErrorMessage"));
        LOGGER.info("************sendPasswordThroughEmail method of  ForgotPasswordController  execution started************");
		return "ForgotPassword";
	}

}
