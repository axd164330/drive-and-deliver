package com.driveanddeliver.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.ui.ModelMap;

/**
 * 
 * @author Amandeep Singh Dhammu
 *
 */
@Controller
public class HomepageController {

	private String contextPath;
	
	public String getContextPath() {
		
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printHello(ModelMap model, HttpServletRequest httpServletRequest) {

		model.addAttribute("message", "Welcome to Drive and Deliver");
		model.addAttribute("contextPath", httpServletRequest.getContextPath());
		this.setContextPath(httpServletRequest.getContextPath());
		return "index";
	}

}