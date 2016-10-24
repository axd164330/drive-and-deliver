package com.driveanddeliver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.driveanddeliver.model.Trip;
import com.driveanddeliver.model.TripFormData;
import com.driveanddeliver.model.User;
import com.driveanddeliver.service.TripService;
import com.driveanddeliver.service.UserService;

@Controller
public class TripController extends HomepageController {

	private UserService userService;

	private TripService tripService;

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
	public String addTrip(@RequestParam(value = "emailId", required = true) String emailId, ModelMap map) {

		TripFormData trip = new TripFormData();
		map.put("contextPath", this.getContextPath());
		map.put("emailId", emailId);
		map.put("tripForm", trip);
		return "addTrip";
	}

	@RequestMapping(value = "/addtripdetails", method = RequestMethod.POST)
	public String addTripDetails(@ModelAttribute("tripDetails") TripFormData trip, ModelMap map) {

		map.put("Trip", trip);
		map.put("contextPath", this.getContextPath());
		User driver = this.userService.getUserDetails(trip.getEmailId());

		this.tripService.saveTripDetails(driver, trip);

		return "tripSuccess";
	}
	
	//added by Pradeep edittripdetails
	
	@RequestMapping(value = "/edittripdetails", method = RequestMethod.POST)
	public String editTripDetails(@ModelAttribute("tripDetails") TripFormData trip, ModelMap map) {
		map.put("Trip", trip);
		map.put("contextPath", this.getContextPath());
		
		this.tripService.updateTripDetails(trip);

		return "editTripSuccess";
	}

	@RequestMapping(value = "/triphistory", method = RequestMethod.GET)
	public String getTripHistory(@RequestParam(value = "emailId", required = true) String emailId, ModelMap map) {

		User driver = this.userService.getUserDetails(emailId);
		map.put("contextPath", this.getContextPath());
		map.put("trips", driver.getTrips());

		return "tripHistory";
	}

	@RequestMapping(value = { "/tripDetails", "/edittrip" }, method = RequestMethod.GET)
	public String getTripDetails(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "e", required = true) String edit, ModelMap map) {
		map.put("contextPath", this.getContextPath());
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
		map.put("contextPath", this.getContextPath());
		this.tripService.deleteTrip(Integer.parseInt(id));

		return "deleteSuccess";
	}

}
