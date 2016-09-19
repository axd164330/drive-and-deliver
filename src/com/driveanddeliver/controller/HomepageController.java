package com.driveanddeliver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.driveanddeliver.model.User;
import com.driveanddeliver.service.UserService;

import org.springframework.ui.ModelMap;

/**
 * 
 * @author Amandeep Singh Dhammu
 *
 */
@Controller
public class HomepageController {

	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printHello(ModelMap model) {

		model.addAttribute("message", "Welcome to Drive and Deliver");

		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";
	}

	@RequestMapping(value = "/accountSummary", method = RequestMethod.GET)
	public String getAccountDetails(ModelMap model) {

		User user = new User();
		user.setName("Amandeep");
		user.setCountry("India");

		this.userService.save(user);

		return "account";
	}

}
