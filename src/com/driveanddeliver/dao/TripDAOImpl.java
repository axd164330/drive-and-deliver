package com.driveanddeliver.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
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
	public void saveTripDetails(User user, TripFormData data) {

		Trip trip = new Trip(user);
		trip.setTimeOfTravel(data.getDateOfTrip());

		Address startAddress = setStartAddress(user, data, trip);

		Address endAddress = setDestinationAddress(user, data, trip);

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

	// added by Pradeep
	@Override
	public void updateTripDetails(TripFormData tripForm) {
		// TODO Auto-generated method stub
		Trip t = getTripDetails(tripForm.getId());
		Address start = getAddresssForTrip(tripForm.getId(), "start");
		Address dest = getAddresssForTrip(tripForm.getId(), "destination");
		Car c = getCarForTrip(tripForm.getId());

		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		t = (Trip) session.merge(t);
		c = (Car) session.merge(c);
		start = (Address) session.merge(start);
		dest = (Address) session.merge(dest);

		t.setTimeOfTravel(tripForm.getDateOfTrip());
		
		start.setAddress1(tripForm.getStartTripStreet1());
		start.setAddress2(tripForm.getStartTripStreet2());
		start.setCity(tripForm.getStartTripCity());
		start.setPhoneNo(tripForm.getStartTripPhone());
		start.setPoBox(tripForm.getStartTripPin());
		start.setCountry(tripForm.getStartTripCountry());
		
		dest.setAddress1(tripForm.getEndTripStreet1());
		dest.setAddress2(tripForm.getEndTripStreet2());
		dest.setCity(tripForm.getEndTripCity());
		dest.setCountry(tripForm.getEndTripCountry());
		dest.setPhoneNo(tripForm.getEndTripPhone());
		dest.setPoBox(tripForm.getEndTripPin());

		c.setCarNumber(tripForm.getCarNumber());
		c.setMake(tripForm.getCarMake());
		c.setModel(tripForm.getCarModel());

		session.saveOrUpdate(t);
		session.saveOrUpdate(start);
		session.saveOrUpdate(dest);
		session.saveOrUpdate(c);

		tx.commit();
		session.close();
	}

	private Car getCarForTrip(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String queryString = "from Car where trip_car_id=:id";
		Query query = session.createQuery(queryString);
		query.setInteger("id", id);
		Object object = query.uniqueResult();

		Car c = (Car) object;

		tx.commit();
		session.close();
		return c;
	}

	private Address getAddresssForTrip(int id, String type) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String queryString = "from Address where trip_address_id=:id and type_of_address=:type";
		Query query = session.createQuery(queryString);
		query.setInteger("id", id);
		query.setString("type", type);

		Object object = query.uniqueResult();

		tx.commit();
		session.close();
		return (Address) object;
	}

	private Car setCarData(TripFormData data, Trip trip) {
		Car car = new Car(trip);
		car.setCarNumber(data.getCarNumber());
		car.setModel(data.getCarModel());
		car.setMake(data.getCarMake());
		return car;
	}

	private Address setDestinationAddress(User user, TripFormData data, Trip trip) {
		Address endAddress = new Address(user, trip);
		endAddress.setAddress1(data.getEndTripStreet1());
		endAddress.setAddress2(data.getEndTripStreet2());
		endAddress.setCity(data.getEndTripCity());
		endAddress.setCountry(data.getEndTripCountry());
		endAddress.setPhoneNo(data.getEndTripPhone());
		endAddress.setPoBox(data.getEndTripPin());
		endAddress.setTypeOfAddress("destination");
		return endAddress;
	}

	private Address setStartAddress(User user, TripFormData data, Trip trip) {
		Address startAddress = new Address(user, trip);
		startAddress.setAddress1(data.getStartTripStreet1());
		startAddress.setAddress2(data.getStartTripStreet2());
		startAddress.setCity(data.getStartTripCity());
		startAddress.setPhoneNo(data.getStartTripPhone());
		startAddress.setPoBox(data.getStartTripPin());
		startAddress.setTypeOfAddress("start");
		startAddress.setCountry(data.getStartTripCountry());
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

	@Override
	public void deleteTrip(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String queryString = "delete from Trip where trip_id=:id";
		Query query = session.createQuery(queryString);
		query.setInteger("id", id);
		query.executeUpdate();

		tx.commit();
		session.close();

	}

	@Override
	public TripFormData loadTripFormDetails(Trip trip) {
		// TODO Auto-generated method stub
		TripFormData td = new TripFormData();
		td.setId(trip.getId());
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		td.setDateOfTripS(df.format(trip.getTimeOfTravel()));
		List<Address> address = trip.getAddress();
		Iterator<Address> it = address.iterator();
		Address ad = null;
		while (it.hasNext()) {
			ad = new Address();
			ad = it.next();
			if (ad.getTypeOfAddress().equalsIgnoreCase("start")) {
				td.setStartTripStreet1(ad.getAddress1());
				td.setStartTripStreet2(ad.getAddress2());
				td.setStartTripCity(ad.getCity());
				td.setStartTripPin(ad.getPoBox());
				td.setStartTripPhone(ad.getPhoneNo());
			} else {
				td.setEndTripStreet1(ad.getAddress1());
				td.setEndTripStreet2(ad.getAddress2());
				td.setEndTripCity(ad.getCity());
				td.setEndTripPin(ad.getPoBox());
				td.setEndTripPhone(ad.getPhoneNo());
			}
		}
		Car car = trip.getCar();
		td.setCarMake(car.getMake());
		td.setCarModel(car.getModel());
		td.setCarNumber(car.getCarNumber());
		return td;
	}

}
