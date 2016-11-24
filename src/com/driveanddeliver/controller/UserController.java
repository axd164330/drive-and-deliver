package com.driveanddeliver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.driveanddeliver.model.Address;
import com.driveanddeliver.model.User;
import com.driveanddeliver.service.SecurityService;
import com.driveanddeliver.service.UserService;
import com.driveanddeliver.validator.UserValidator;

/**
 * 
 * @author Amandeep Singh Dhammu
 *
 */

@Controller
public class UserController{

	
	private UserService userService;
	
	@Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
		
	@Autowired(required = true)	  
	@Qualifier(value = "userService") public void setUserService(UserService userService) {
	    this.userService = userService;
	}	
	
	public SecurityService getSecurityService() {
		return securityService;
	}
	
	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}
	
	public UserValidator getUserValidator() {
		return userValidator;
	}
	
	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model,String error, String logout){
		if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
	}

	@RequestMapping(value = "/accountsummary", method = RequestMethod.GET)
	public String getAccountDetails(@RequestParam(value = "username", required = false) String username, ModelMap model) {
		
		User user = this.userService.getUserDetails(username);
		
		model.put("user", user);
		//model.put("contextPath", this.getContextPath());
		
		if(user.getTypeOfUser().equalsIgnoreCase("driver")){
			return "accountForDriver";
		}else{			
			return "accountForSender";
		}
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }
	
	@RequestMapping(value="/addAddress",method=RequestMethod.GET)
	public String addAddress(@RequestParam(value="username",required=false) String username,Model model){
		
		
		model.addAttribute("username",username);
		model.addAttribute("addressForm",new Address());
		
		return "addAddress";
		
	}
	
	
	@RequestMapping(value="/addAddress",method=RequestMethod.POST)
	public String addAddress(@ModelAttribute("addressForm") Address addressForm, Model map){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in user name
		
		User user = userService.getUserDetails(username);
		
		Address address = new Address(user);
		
		address.setAddress1(addressForm.getAddress1());
		address.setAddress2(addressForm.getAddress2());
		address.setAddressInfo("profileAddress");
		address.setCity(addressForm.getCity());
		address.setCountry(addressForm.getCountry());
		address.setPhoneNo(addressForm.getPhoneNo());
		address.setPoBox(addressForm.getPoBox());
		
		userService.addAddress(address);
		
		map.addAttribute("username",username);
		return "redirect:/addressList";
	}
	
	
	@RequestMapping(value="/addressList", method= RequestMethod.GET)
	public String getProfileAddress(ModelMap model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in user name

		model.put("addressList", userService.getProfileAddress(username));
		
		return "profileAddressList";
	}
	
}
