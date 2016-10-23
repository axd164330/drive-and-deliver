package com.driveanddeliver.dao;

import com.driveanddeliver.model.User;

public interface UserDAO {

	public void save(User user);
	
	public User getUserDetails(String emailId);

}
