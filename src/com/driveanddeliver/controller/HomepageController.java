package com.driveanddeliver.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.driveanddeliver.model.Trip;
import com.driveanddeliver.model.TripFormData;
import com.driveanddeliver.model.User;
import com.driveanddeliver.service.DriverService;
import com.driveanddeliver.service.TripService;

import org.springframework.ui.ModelMap;

/**
 * 
 * @author Amandeep Singh Dhammu
 *
 */
@Controller
public class HomepageController {

	// private UserService userService;

	private String contextPath;

	private TripService tripService;

	private DriverService driverService;

	public TripService getTripService() {
		return tripService;
	}

	@Autowired(required = true)
	@Qualifier(value = "tripService")
	public void setTripService(TripService tripService) {
		this.tripService = tripService;
	}

	public DriverService getDriverService() {
		return driverService;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	@Autowired(required = true)
	@Qualifier(value = "driverService")
	public void setDriverService(DriverService driverService) {
		this.driverService = driverService;
	}

	/*
	 * @Autowired(required = true)
	 * 
	 * @Qualifier(value = "userService") public void setUserService(UserService
	 * userService) { this.userService = userService;
	 * 
	 * }
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printHello(ModelMap model, HttpServletRequest httpServletRequest) {

		model.addAttribute("message", "Welcome to Drive and Deliver");
		model.addAttribute("contextPath", httpServletRequest.getContextPath());
		this.setContextPath(httpServletRequest.getContextPath());
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.put("contextPath", this.getContextPath());
		return "login";
	}

	@RequestMapping(value = "/accountsummary", method = RequestMethod.GET)
	public String getAccountDetails(@RequestParam(value = "emailId", required = false) String emailId, ModelMap model) {

		/*
		 * User user = new User(); user.setName("Testing");
		 * user.setCountry("India"); user.setEmailId("sdf@test.com");
		 * user.setTypeOfUser("driver");
		 * 
		 * Address address = new Address(user); address.setAddress1("bye");
		 * address.setAddress2("test2"); address.setCity("Richardson");
		 * address.setPhoneNo("1234"); address.setPoBox("6777");
		 * 
		 * Address address2 = new Address(user); address2.setAddress1("okay");
		 * address2.setAddress2("test2"); address2.setCity("richardson");
		 * address2.setPhoneNo("1234"); address2.setPoBox("65544");
		 * 
		 * 
		 * List<Address> addresses = new ArrayList<Address>();
		 * 
		 * 
		 * addresses.add(address); addresses.add(address2);
		 * 
		 * user.setAddresses(addresses);
		 * 
		 * this.userService.save(user);
		 * 
		 */
		User driver = this.driverService.getDriverDetails(emailId);

		System.out.println("driver" + driver.getAddresses());

		model.put("driver", driver);
		model.put("contextPath", this.getContextPath());
		return "account";
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
		User driver = this.driverService.getDriverDetails(trip.getEmailId());

		this.tripService.saveTripDetails(driver, trip);

		return "tripSuccess";
	}

	@RequestMapping(value = "/triphistory", method = RequestMethod.GET)
	public String getTripHistory(@RequestParam(value = "emailId", required = true) String emailId, ModelMap map) {

		User driver = this.driverService.getDriverDetails(emailId);
		map.put("contextPath", this.getContextPath());
		map.put("trips", driver.getTrips());

		return "tripHistory";
	}

	@RequestMapping(value = "/tripDetails", method = RequestMethod.GET)
	public String getTripDetails(@RequestParam(value = "id", required = true) String id, ModelMap map) {
		map.put("contextPath", this.getContextPath());
		map.put("tripDetails", (Trip) this.getTripService().getTripDetails(Integer.parseInt(id)));

		return "tripDetails";
	}

}