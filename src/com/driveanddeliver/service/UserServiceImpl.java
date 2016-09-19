package com.driveanddeliver.service;

import com.driveanddeliver.dao.UserDAO;
import com.driveanddeliver.model.User;

public class UserServiceImpl implements UserService{

	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void save(User user) {		
		this.userDAO.save(user);
	}

}
