package com.driveanddeliver.service;

import com.driveanddeliver.dao.DriverDAO;
import com.driveanddeliver.model.User;

public class DriverServiceImpl extends UserServiceImpl implements DriverService {

	private DriverDAO driverDAO;

	public DriverDAO getDriverDAO() {
		return driverDAO;
	}

	public void setDriverDAO(DriverDAO driverDAO) {
		this.driverDAO = driverDAO;
	}

	@Override
	public User getDriverDetails(String email) {

		return this.driverDAO.getDriverDetails(email);
	}

}
