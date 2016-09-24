package com.driveanddeliver.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.driveanddeliver.model.Address;
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
		user.setEmailId("asdhammu@gmail.com");
		user.setTypeOfUser("driver");
		
		Address address = new Address();
		address.setAddress1("test1");
		address.setAddress2("test2");
		address.setCity("Dallas");
		address.setPhoneNo("1234");
		address.setPoBox("123");
		
		Address address2 = new Address();
		address2.setAddress1("test1");
		address2.setAddress2("test2");
		address2.setCity("Dallas");
		address2.setPhoneNo("1234");
		address2.setPoBox("123");
		
		
		List<Address> addresses = new ArrayList<Address>(); 
		
		addresses.add(address);
		addresses.add(address2);
		
		user.setAddresses(addresses);
		
		this.userService.save(user);

		return "account";
	}

}
