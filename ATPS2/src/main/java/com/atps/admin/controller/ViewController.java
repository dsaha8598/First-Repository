package com.atps.admin.controller;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atps.admin.servicet.AdminService;
import com.atps.usermanagement.domain.UserDomain;
import com.atps.usermanagement.entity.UserEntity;

/**
* this is the controller class for creating agency account
* @author user
*
*/
@Controller
public class ViewController {
	/**
	 * injecting Admin service class to controller
	 */
	@Autowired
	AdminService adminService;
	
	static Integer currentPageNo=1;
	Page<UserEntity> pageData=null;
	
	private static Logger LOGGER = LogManager.getLogger(AgencySignupController.class);
	
	
	@RequestMapping(value="/viewAgencies",method=RequestMethod.GET)
	public String viewAgencies(Model model,@RequestParam(value="pn" ,required=false)Integer pn) {
		if(pn!=null) {
			currentPageNo=pn;
			//to get the pagedata
			 pageData=adminService.getPageData(currentPageNo);
			
		}
		else {
			//to get the pagedata
			 pageData=adminService.getPageData(currentPageNo);
		}

		LOGGER.info("************viewAgencies method of  AgencySignupController execution started************");
		
		int totalPages=pageData.getTotalPages();
		//to get list of records using pageData
		List<UserDomain> listOfUsers=adminService.getAllAgencies(pageData);
		//sending current page no to jsp
		model.addAttribute("cp",currentPageNo);
		//sending total page no
		model.addAttribute("tp",totalPages);
		model.addAttribute("listUser",listOfUsers);
		//for activate and deactivate key
		model.addAttribute("activeStatus","Y");
	
	
		return "ViewAgencies";
	}

}
