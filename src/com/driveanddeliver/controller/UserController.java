package com.driveanddeliver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.driveanddeliver.model.User;
import com.driveanddeliver.service.UserService;

@Controller
public class UserController extends HomepageController {

	
	private UserService userService;
		
	@Autowired(required = true)	  
	@Qualifier(value = "userService") public void setUserService(UserService userService) {
	    this.userService = userService;
	}	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model){
		model.put("contextPath", this.getContextPath());
		return "login";
	}

	@RequestMapping(value = "/accountsummary", method = RequestMethod.GET)
	public String getAccountDetails(@RequestParam(value = "emailId", required = false) String emailId, ModelMap model) {
		
		User user = this.userService.getUserDetails(emailId);
		
		model.put("user", user);
		model.put("contextPath", this.getContextPath());
		
		if(user.getTypeOfUser().equalsIgnoreCase("driver")){
			return "accountForDriver";
		}else{			
			return "accountForSender";
		}
	}

	
}
