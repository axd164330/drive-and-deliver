package com.driveanddeliver.dao;

import com.driveanddeliver.model.User;

public interface DriverDAO extends UserDAO   {

	public User getDriverDetails(String email);
	
}
