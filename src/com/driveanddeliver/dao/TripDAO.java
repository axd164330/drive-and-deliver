package com.driveanddeliver.dao;

import com.driveanddeliver.model.Trip;
import com.driveanddeliver.model.TripFormData;
import com.driveanddeliver.model.User;

public interface TripDAO {

	public void saveTripDetails(User user, TripFormData tripFormData);

	public Trip getTripDetails(int id);
	
	//added by Pradeep
	public void deleteTrip(int id);

	public TripFormData loadTripFormDetails(Trip trip);

	public void updateTripDetails(TripFormData trip);
	
	public void updateTrip(Trip trip);
}
