package com.atps.tagPurchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atps.bindingClasses.RegistrationSummery;
import com.atps.bindingClasses.VehiclesRegDtlsEntity;
import com.atps.tagPurchase.service.TagPurchaseService;


/**
 * Controller class
 * @author Dipak
 *
 */
@Controller
public class PurchaseTagController {
	/**
	 * injecting service class object
	 */
	@Autowired
	TagPurchaseService service;
	
	/**
	 * this method loads the form to enter the regNum
	 * @param model
	 * @return EnterVehicleRegnoPage
	 */
	@RequestMapping("/loadEnterRegistrationNoForm")
	public String loadTheFormToEnterRegNum(Model model) {
		VehiclesRegDtlsEntity domain=new VehiclesRegDtlsEntity();
		model.addAttribute("domain",domain);
		return "EnterVehicleRegnoPage";
	}
	
	@RequestMapping(value="/getAdressDetails",method=RequestMethod.POST)
	public String getAdressDetailsByNumber(Model model,@ModelAttribute("domain")VehiclesRegDtlsEntity domain) {
		RegistrationSummery summery=service.getAdressDetails(domain.getVehicle_reg_num());
		model.addAttribute("adress",summery.getAdressEntity());
		System.out.println(summery);
		return "EnterVehicleRegnoPage";
		
	}

}
