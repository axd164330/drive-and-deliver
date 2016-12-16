package com.driveanddeliver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.driveanddeliver.model.Trip;
import com.driveanddeliver.model.TripFormData;
import com.driveanddeliver.model.User;
import com.driveanddeliver.service.TripService;
import com.driveanddeliver.service.UserService;
import com.driveanddeliver.validator.TripValidator;

/**
 * 
 * @author Amandeep Singh Dhammu
 *
 */

@Controller
public class TripController{

	private UserService userService;

	private TripService tripService;

	@Autowired(required=true)
	private TripValidator tripValidator;	
	
	@Autowired(required = true)
	@Qualifier(value = "tripService")
	public void setTripService(TripService tripService) {
		this.tripService = tripService;
	}

	public TripService getTripService() {
		return tripService;
	}

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/addtrip", method = RequestMethod.GET)
	public String addTrip(ModelMap map) {
		map.put("tripForm", new TripFormData());
		
		return "addTrip";
	}

	@RequestMapping(value = "/addtrip", method = RequestMethod.POST)
	public String addTripDetails(@ModelAttribute("tripForm") TripFormData tripForm,BindingResult bindingResult, ModelMap map) {
		
		/**
		 * 1. Binding result and map in the arguments should be in the given order.
		 * Otherwise the framework throws error of 400 not found
		 * 
		 * 2. model attribute (tripForm) and type of tripformdata should have same name 
		 */
		
		tripValidator.validate(tripForm, bindingResult);
		
		if(bindingResult.hasErrors()){
			return "addTrip";
		}
		
		map.put("Trip", tripForm);
		User driver = this.userService.getUserDetails(tripForm.getEmailId());

		this.tripService.saveTripDetails(driver, tripForm);

		return "tripSuccess";
	}
	
	

	@RequestMapping(value = "/triphistory", method = RequestMethod.GET)
	public String getTripHistory(@RequestParam(value = "emailId", required = true) String emailId, ModelMap map) {

		User driver = this.userService.getUserDetails(emailId);
		//map.put("contextPath", this.getContextPath());
		map.put("trips", driver.getTrips());

		return "tripHistory";
	}

	@RequestMapping(value = { "/tripDetails", "/edittrip" }, method = RequestMethod.GET)
	public String getTripDetails(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "e", required = true) String edit, ModelMap map) {
		//map.put("contextPath", this.getContextPath());
		map.put("tripDetails", (Trip) this.getTripService().getTripDetails(Integer.parseInt(id)));
		if (edit.equalsIgnoreCase("true")) {
			TripFormData loadedTripForm = new TripFormData();
			loadedTripForm = this.getTripService().loadTripFormData((Trip)map.get("tripDetails"));
			map.put("tripID", id);
			map.put("loadedTripForm", loadedTripForm);
			return "editTrip";
		} else {
			return "tripDetails";
		}
	}

	// added by Pradeep deleteTrip
	@RequestMapping(value = "/deleteTrip", method = RequestMethod.GET)
	public String deleteTrip(@RequestParam(value = "id", required = true) String id, ModelMap map) {
		//map.put("contextPath", this.getContextPath());
		this.tripService.deleteTrip(Integer.parseInt(id));

		return "deleteSuccess";
	}

	//added by Pradeep edittripdetails
	
	@RequestMapping(value = "/edittripdetails", method = RequestMethod.POST)
	public String editTripDetails(@ModelAttribute("tripForm") TripFormData trip, ModelMap map) {
		map.put("Trip", trip);
		//map.put("contextPath", this.getContextPath());
		
		this.tripService.updateTripDetails(trip);

		return "editTripSuccess";
	}
}
