package com.atps.usermanagement.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atps.usermanagement.constants.AppConstants;
import com.atps.usermanagement.service.UserService;

@Controller
/**
 * this is the controller class for mail sender
 * 
 * @author user
 *
 */
public class MailSenderController {

	/**
	 * injecting service class object
	 */
	@Autowired
	UserService service;

	private static Logger LOGGER = LogManager.getLogger(MailSenderController.class);

	/**
	 * this is to send the mail to the customer with temporary password
	 * 
	 * @param model
	 * @returnMailSender
	 */
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public String sendEmail(Model model) throws Exception {
		LOGGER.info("************sendEmail method of MailSenderController execution started************");
		service.sendUserMail();
		LOGGER.info("************sendEmail method of MailSenderController execution ended************");
		return AppConstants.MAILSENDER;//"MailSender"
	}
}
