package com.atps.usermanagement.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atps.usermanagement.constants.AppConstants;
import com.atps.usermanagement.domain.UserDomain;
import com.atps.usermanagement.service.UserService;

@Controller
/**
 * this is controller class to update the password
 * 
 * @author user
 *
 */
public class UpdatePasswordController {

	/**
	 * injecting service class to controller
	 */
	@Autowired
	UserService service;

	private static Logger LOGGER = LogManager.getLogger(UpdatePasswordController.class);

	/**
	 * this is to update the password
	 * 
	 * @param model
	 * @return UpdatePassword
	 */

	@RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
	public String updatePassword(Model model, @RequestParam("email") String email) {
		LOGGER.info("************updatePassword method of UpdatePasswordController execution started************");
		UserDomain domain = new UserDomain();
		domain.setEmail(email);
		model.addAttribute("domain", domain);
		LOGGER.info("************updatePassword method of UpdatePasswordController execution ened************");
		return AppConstants.UPDATEPASSWORD;//UpdatePassword
	}

	/**
	 * this method is to update the password
	 * @param model
	 * @param domain
	 * @return AppConstants.UPDATEPASSWORD,forward:/login
	 */
	@RequestMapping(value = "/updatePasswordPOST", method = RequestMethod.POST)
	public String processUpdatedPassword(Model model, @ModelAttribute("domain") UserDomain domain) {
		LOGGER.info(
				"************processUpdatedPassword method of UpdatePasswordController execution started************");
		String msg = service.updatePasswordByEmail(domain);
		if (msg == "success") {
			LOGGER.info("************if block of processUpdatedPassword method executed***********");
			return "forward:/login";
		} else {
			LOGGER.info("************else block of processUpdatedPassword method executed***********");
			model.addAttribute("msg", "temporary password not matching");
			model.addAttribute("domain", domain);
			return AppConstants.UPDATEPASSWORD;//UpdatePassword
		}

	}
}
