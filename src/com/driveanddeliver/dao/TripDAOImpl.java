package com.driveanddeliver.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.driveanddeliver.model.Address;
import com.driveanddeliver.model.Car;
import com.driveanddeliver.model.Trip;
import com.driveanddeliver.model.TripFormData;
import com.driveanddeliver.model.User;

public class TripDAOImpl implements TripDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void saveTripDetails(User user,TripFormData data) {
		
		Trip trip = new Trip(user);
		trip.setTimeOfTravel(data.getDateOfTrip());
		
		Address startAddress = setStartAddress(user, data, trip);

		Address endAddress = setDestinationAddress(user, data,trip);
		
		List<Address> addresses = new ArrayList<>();
		addresses.add(startAddress);
		addresses.add(endAddress);		
		
		Car car = setCarData(data, trip);
		
		trip.setAddress(addresses);
		trip.setCar(car);
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(trip);
		
		tx.commit();
		session.close();
		
	}

	private Car setCarData(TripFormData data, Trip trip) {
		Car car = new Car(trip);
		car.setCarNumber(data.getCarNumber());
		car.setModel(data.getCarModel());
		car.setMake(data.getCarMake());
		return car;
	}

	private Address setDestinationAddress(User user, TripFormData data,Trip trip) {
		Address endAddress = new Address(user,trip);
		endAddress.setAddress1(data.getEndTripStreet1());
		endAddress.setAddress2(data.getEndTripStreet2());
		endAddress.setCity(data.getEndTripCity());
		endAddress.setPhoneNo(data.getEndTripPhone());
		endAddress.setPoBox(data.getEndTripPin());
		endAddress.setTypeOfAddress("destination");
		return endAddress;
	}

	private Address setStartAddress(User user, TripFormData data, Trip trip) {
		Address startAddress = new Address(user,trip);
		startAddress.setAddress1(data.getStartTripStreet1());
		startAddress.setAddress2(data.getStartTripStreet2());
		startAddress.setCity(data.getStartTripCity());
		startAddress.setPhoneNo(data.getStartTripPhone());
		startAddress.setPoBox(data.getStartTripPin());
		startAddress.setTypeOfAddress("start");
		return startAddress;
	}

	@Override
	public Trip getTripDetails(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String queryString = "from Trip where trip_id=:id";
		Query query = session.createQuery(queryString);
		query.setInteger("id", id); 
		Object object = query.uniqueResult();
		
		Trip tripdetails = (Trip) object;
		
		tx.commit();
		session.close();
		return tripdetails;
	}

}
