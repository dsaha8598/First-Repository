package com.atps.usermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String  loadHome(Model model) {
	return "Home";
	}

}
