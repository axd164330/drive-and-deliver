package com.driveanddeliver.service;

import com.driveanddeliver.model.User;

public interface UserService {

	public void save(User user);
	public User getUserDetails(String emailId);

	public User findByUsername(String username);
}
