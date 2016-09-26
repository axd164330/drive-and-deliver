package com.driveanddeliver.dao;

import com.driveanddeliver.model.Trip;
import com.driveanddeliver.model.TripFormData;
import com.driveanddeliver.model.User;

public interface TripDAO {

	public void saveTripDetails(User user, TripFormData tripFormData);

	public Trip getTripDetails(int id);
}
