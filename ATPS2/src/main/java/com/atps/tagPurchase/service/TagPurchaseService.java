package com.atps.tagPurchase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atps.bindingClasses.RegistrationSummery;

@Service
public class TagPurchaseService {

	/**
	 * injecting RestTemplate object
	 */
	@Autowired
	RestTemplate rest;
	
	private static String url=null;
	public RegistrationSummery getAdressDetails(String regNum) {
		url="http://localhost:9090/RTO//getVehicleSummary/"+regNum;
		ResponseEntity<RegistrationSummery> entity=rest.getForEntity(url,RegistrationSummery.class);
		RegistrationSummery summery=entity.getBody();
		return summery;
	}
}
