package com.driveanddeliver.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.driveanddeliver.model.Address;
import com.driveanddeliver.model.MyPackage;
import com.driveanddeliver.model.PackageFormData;
import com.driveanddeliver.model.User;

public class PackageDAOImpl implements PackageDAO{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void savePackageDetails(User user, PackageFormData data) {		
		
		MyPackage myPackage = new MyPackage(user);
		myPackage.setPickupDate(data.getDateOfTrip());
		
		Address startAddress = setPickupAddress(user, data, myPackage);

		Address endAddress = setDropAddress(user, data, myPackage);
		
		List<Address> addresses = new ArrayList<>();
		addresses.add(startAddress);
		addresses.add(endAddress);		
		myPackage.setHeight(Float.parseFloat(data.getHeight()));
		myPackage.setLength(Float.parseFloat(data.getLength()));
		myPackage.setWidth(Float.parseFloat(data.getWidth()));
		myPackage.setTimestamp(new Timestamp(System.currentTimeMillis()));
		myPackage.setPackageStatus(Status.INPROGRESS.toString());
		myPackage.setAddress(addresses);
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(myPackage);
		
		tx.commit();
		session.close();
		
	}
	
	private Address setDropAddress(User user, PackageFormData data,MyPackage apackage) {
		Address endAddress = new Address(user,apackage);
		endAddress.setAddress1(data.getEndTripStreet1());
		endAddress.setAddress2(data.getEndTripStreet2());
		endAddress.setCity(data.getEndTripCity());
		endAddress.setPhoneNo(data.getEndTripPhone());
		endAddress.setPoBox(data.getEndTripPin());
		endAddress.setTypeOfAddress("drop");
		endAddress.setCountry(data.getEndTripCountry());
		endAddress.setAddressInfo("packageAddress");
		endAddress.setState(data.getEndTripState());
		return endAddress;
	}

	private Address setPickupAddress(User user, PackageFormData data,MyPackage apackage) {
		Address startAddress = new Address(user, apackage);
		startAddress.setAddress1(data.getStartTripStreet1());
		startAddress.setAddress2(data.getStartTripStreet2());
		startAddress.setCity(data.getStartTripCity());
		startAddress.setPhoneNo(data.getStartTripPhone());
		startAddress.setPoBox(data.getStartTripPin());
		startAddress.setTypeOfAddress("pickup");
		startAddress.setCountry(data.getStartTripCountry());
		startAddress.setAddressInfo("packageAddress");
		startAddress.setState(data.getStartTripState());
		return startAddress;
	}
	
	@Override
	public MyPackage getPackageDetails(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String queryString = "from MyPackage where package_id=:id";
		Query query = session.createQuery(queryString);
		query.setInteger("id", id); 
		Object object = query.uniqueResult();
		
		MyPackage pdetails = (MyPackage) object;
		
		tx.commit();
		session.close();
		return pdetails;
	}

	@Override
	public void updatePackageDetails(MyPackage myPackage) {

		//myPackage.setTripId(trip);
		//trip.setMyPackage(myPackage);
		myPackage.setPackageStatus(Status.CONFIRMED.toString());
		//trip.setTripStatus(Status.CONFIRMED.toString());
		
		Session session = this.sessionFactory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		
		session.merge(myPackage);
		
		transaction.commit();
		
		session.close();
		/*Session session1 = this.sessionFactory.openSession();
		Transaction transaction1 = (Transaction) session1.beginTransaction();
		
		session1.merge(trip);
		
		
		transaction1.commit();*/
		
	}
	
}
