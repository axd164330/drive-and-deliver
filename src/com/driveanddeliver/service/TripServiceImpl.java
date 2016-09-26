package com.driveanddeliver.service;

import com.driveanddeliver.dao.TripDAO;
import com.driveanddeliver.model.Trip;
import com.driveanddeliver.model.TripFormData;
import com.driveanddeliver.model.User;

public class TripServiceImpl implements TripService {

	private TripDAO tripDAO;

	public TripDAO getTripDAO() {
		return tripDAO;
	}

	public void setTripDAO(TripDAO tripDAO) {
		this.tripDAO = tripDAO;
	}

	@Override
	public void saveTripDetails(User user,TripFormData tripFormData) {
		this.tripDAO.saveTripDetails(user,tripFormData);
	}

	@Override
	public Trip getTripDetails(int id) {
		return this.tripDAO.getTripDetails(id);
	}

}
