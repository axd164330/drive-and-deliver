package com.driveanddeliver.service;

import com.driveanddeliver.model.Trip;
import com.driveanddeliver.model.TripFormData;
import com.driveanddeliver.model.User;

public interface TripService {

	public void saveTripDetails(User user, TripFormData trip);
	
	public Trip getTripDetails(int id);
	
	//added by Pradeep
	public void deleteTrip(int id);

	public TripFormData loadTripFormData(Trip trip);

	public void updateTripDetails(TripFormData trip);
}
