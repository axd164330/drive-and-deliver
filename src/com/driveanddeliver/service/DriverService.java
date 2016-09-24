package com.driveanddeliver.service;


import com.driveanddeliver.model.Driver;

public interface DriverService extends UserService {

	public Driver getDriverDetails(String email);
	
}
