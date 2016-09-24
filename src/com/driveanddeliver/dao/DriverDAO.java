package com.driveanddeliver.dao;


import com.driveanddeliver.model.Driver;

public interface DriverDAO extends UserDAO   {

	public Driver getDriverDetails(String email);
	
}
