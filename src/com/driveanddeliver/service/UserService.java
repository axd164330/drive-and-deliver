package com.driveanddeliver.service;

import java.util.List;

import com.driveanddeliver.model.Address;
import com.driveanddeliver.model.User;

public interface UserService {

	public void save(User user);
	public User getUserDetails(String emailId);

	public User findByUsername(String username);
	
	public List<Address> getProfileAddress(String username);

	public void addAddress(Address address);
}
