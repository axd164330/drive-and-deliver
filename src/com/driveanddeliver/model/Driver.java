package com.driveanddeliver.model;

import java.util.List;

public class Driver extends User {

	private List<Trip> trips;

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
	
}

