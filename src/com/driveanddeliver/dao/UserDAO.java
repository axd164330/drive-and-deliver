package com.driveanddeliver.dao;

import java.util.List;

import com.driveanddeliver.model.Address;
import com.driveanddeliver.model.Trip;
import com.driveanddeliver.model.User;

public interface UserDAO {

	public void save(User user);
	
	public User getUserDetails(String emailId);
	
	//public User findByUsername(String username);
	
	public List<Address> getProfileAddress(String username);

	public void addAddress(Address address);
	
	public List<Trip> getTripsForNextWeek();
}
