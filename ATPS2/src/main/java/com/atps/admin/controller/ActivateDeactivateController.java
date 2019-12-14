package com.atps.admin.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atps.admin.servicet.AdminService;
import com.atps.usermanagement.entity.UserEntity;

/**
 * controller class
 * 
 * @author user
 *
 */
@Controller
public class ActivateDeactivateController {

	private static Logger LOGGER = LogManager.getLogger(ActivateDeactivateController.class);
	/**
	 * injecting service class object
	 */
	@Autowired
	AdminService service;

	/**
	 * recieves the id from jsp page sends the id to service class methods to set
	 * active status "N"
	 * @param model
	 * @param id
	 * @return forward:/viewAgencies
	 */
	@RequestMapping("/deActivate")
	public String deActivate(Model model, @RequestParam("id") Integer id) {
		LOGGER.info("************deActivate method of  ActivateDeactivateController execution started************");
		UserEntity userId = service.deactivate(id);
		if (userId != null) {
			model.addAttribute("msg", "activated");
			// model.addAttribute("activeStatus","Y");
		}
		LOGGER.info("************deActivate method of  ActivateDeactivateController execution started************");

		return "forward:/viewAgencies";

	}

	/**
	 * recieves the id from jsp page sends the id to service class methods to set
	 * active status "N"
	 * 
	 * @param model
	 * @param id
	 * @return forward:/viewAgencies
	 */

	@RequestMapping("/activate")
	public String activate(Model model, @RequestParam("id") Integer id) {
		LOGGER.info("************ activate method of  ActivateDeactivateController execution started************");
		UserEntity userId = service.activate(id);
		if (userId != null)
			model.addAttribute("msg", "deactivated");
		// model.addAttribute("activeStatus","Y");
		LOGGER.info("************ activate method of  ActivateDeactivateController execution started************");

		return "forward:/viewAgencies";

	}
}
