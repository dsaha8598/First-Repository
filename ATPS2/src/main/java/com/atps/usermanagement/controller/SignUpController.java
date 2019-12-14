package com.atps.usermanagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atps.usermanagement.constants.AppConstants;
import com.atps.usermanagement.domain.UserDomain;
import com.atps.usermanagement.entity.UserEntity;
import com.atps.usermanagement.service.UserService;

@Controller
/**
 * controller for signup functionality
 * 
 * @author user
 *
 */
public class SignUpController {

	@Autowired
	/**
	 * injecting service class to controller
	 */
	UserService service;

	private static Logger LOGGER = LogManager.getLogger(SignUpController.class);

	/**
	 * 
	 * @param model
	 * @return SignUp
	 */
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String loadSignUpForm(Model model) {
		LOGGER.info("************loadSignUpForm method of SignUpController execution started************");
		UserDomain domain = new UserDomain();
		model.addAttribute("domain", domain);
		LOGGER.info("************loadSignUpForm method of SignUpController execution started************");
		return AppConstants.SIGNUP;//SignUp
	}
	
	/** this is recieving the ajax call with the mail id
	 * sending the mail to the sevice class
	 * @param req
	 * @param model
	 * @return message
	 */
	@RequestMapping(value="/checkUniqueEmail", method=RequestMethod.GET)
	public @ResponseBody String checkUniqueNess(HttpServletRequest req,Model model) {
		String email;
		email=req.getParameter("email");
		int count=service.checkEmail(email);
		System.out.println(count);
		if(count==0) {
			return "succes";
		}
		return "failure";
	}

	/**
	 * 
	 * @param model
	 * @param domain
	 * @return
	 */
	@RequestMapping(value = "/signUpPost", method = RequestMethod.POST)
	public String storeUserData(Model model, @ModelAttribute("domain") UserDomain domain) {
		LOGGER.info("************storeUserData method of SignUpController execution started************");
		System.out.println(domain);
		UserEntity userId = service.saveUserDetails(domain);
		model.addAttribute("obj", userId);
		LOGGER.info("************storeUserData method of SignUpController execution started************");
		return "forward:/sendEmail";
	}

}
