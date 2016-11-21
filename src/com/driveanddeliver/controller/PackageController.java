package com.driveanddeliver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.driveanddeliver.model.MyPackage;
import com.driveanddeliver.model.PackageFormData;
import com.driveanddeliver.model.User;
import com.driveanddeliver.service.PackageService;
import com.driveanddeliver.service.UserService;

/**
 * 
 * @author Amandeep Singh Dhammu
 *
 */
@Controller
public class PackageController{

	private UserService userService;

	private PackageService packageService;
		
	@Autowired(required = true)	  
	@Qualifier(value = "userService") 
	public void setUserService(UserService userService) {
	    this.userService = userService;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "packageService")
	public void setPackageService(PackageService packageService) {
		this.packageService = packageService;

	}
	
	@RequestMapping(value = "/addPackage", method = RequestMethod.GET)
	public String addPackage(@RequestParam(value = "emailId", required = true) String emailId, ModelMap map) {

		PackageFormData packageForm = new PackageFormData();
		//map.put("contextPath", this.getContextPath());
		map.put("emailId", emailId);
		map.put("packageForm", packageForm);
		
		return "addPackage";
	}
	
	
	@RequestMapping(value = "/addpackagedetails", method = RequestMethod.POST)
	public String addPackageDetails(@ModelAttribute("packageDetails") PackageFormData carPackage, ModelMap map) {
				
		map.put("Package", carPackage);
		
		User driver = this.userService.getUserDetails(carPackage.getEmailId());
		
		this.packageService.savePackageDetails(driver, carPackage);
		//map.put("contextPath", this.getContextPath());
		return "packageSuccess";
	}
	
	@RequestMapping(value = "/packagehistory", method = RequestMethod.GET)
	public String getPackageHistory(@RequestParam(value = "emailId", required = true) String emailId, ModelMap map){
		
		User user = this.userService.getUserDetails(emailId);
		
		map.put("packages",user.getPackages());
		//map.put("contextPath", this.getContextPath());
		
		return "packageHistory";
	}
	
	@RequestMapping(value = "/packageDetails", method = RequestMethod.GET)
	public String getPackageDetails(@RequestParam(value = "id", required = true) String id, ModelMap map){
		
		map.put("packageDetails", (MyPackage) this.packageService.getPackageDetails(Integer.parseInt(id)));
		//map.put("contextPath", this.getContextPath());
		
		return "packageDetails";
		
	}
	
	@RequestMapping(value = "/cancelPackage", method = RequestMethod.GET)
	public String cancelPackage(ModelMap map){
		
		//map.put("packageDetails", (MyPackage) this.packageService.getPackageDetails(Integer.parseInt(id)));
		//map.put("contextPath", this.getContextPath());
		
		map.put("cancelPackageMsg", "Package has been canceled");
		
		return "packageHistory";
		
	}
	
	
	
}
