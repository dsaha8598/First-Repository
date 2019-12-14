package com.atps.admin.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atps.admin.servicet.AdminService;
import com.atps.usermanagement.domain.UserDomain;
import com.atps.usermanagement.entity.UserEntity;

/**
 * this is the controller class for creating agency account
 * @author user
 *
 */
@Controller
public class AgencySignupController {
	
	/**
	 * injecting service class to controller
	 */
	@Autowired
	AdminService adminService;
	
	private static Logger LOGGER = LogManager.getLogger(AgencySignupController.class);
	
	/**
	 * creates and sends the domain class object as mpodel attribute
	 * loads the signup page
	 * @param model
	 * @return AgencyRegister
	 */
	@RequestMapping("/registerAgency")
	public String loadAgencyRegisterForm(Model model) {
		LOGGER.info("************loadAgencyRegisterForm method of  AgencySignupController execution started************");
		UserDomain domain=new UserDomain();
		model.addAttribute("domain",domain);
		LOGGER.info("************loadAgencyRegisterForm method of  AgencySignupController execution ended************");
		return "AgencyRegister";
	}
	/**
	 * recieves form data
	 * saves data in database
	 * sends mail to user
	 * @param model
	 * @param domain
	 * @return MailSender
	 */
	@RequestMapping(value="/registerAgencyPost",method=RequestMethod.POST)
	public String registerAgency(Model model,@ModelAttribute("domain")UserDomain domain) {
		LOGGER.info("************registerAgency method of  AgencySignupController execution started************");
		UserEntity userId = adminService.saveAdminDetails(domain);
		adminService.sendUserMail();
		model.addAttribute("obj", userId);
		LOGGER.info("************registerAgency method of  AgencySignupController execution ended************");
		return "MailSender";
	}

}
