package com.driveanddeliver.service;


import com.driveanddeliver.model.User;

public interface DriverService extends UserService {

	public User getDriverDetails(String email);
	
}
