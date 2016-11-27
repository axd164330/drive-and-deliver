package com.driveanddeliver.dao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.driveanddeliver.model.Address;
import com.driveanddeliver.model.Trip;
import com.driveanddeliver.model.User;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		
		tx.commit();
		session.close();
	}

	@Override
	public User getUserDetails(String username) {
		
		Session session = this.sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		String queryString = "from User where username=:username";
		Query query = session.createQuery(queryString);
		query.setString("username", username); 
		Object object = query.uniqueResult();
		
		User user = (User) object;
		
		transaction.commit();
		session.close();
		return user;
		

	}

	@Override
	public List<Address> getProfileAddress(String username) {
	
		if(username==null){
			return null;
		}
		
		Session session = this.sessionFactory.openSession();
		
		String queryString = "from User where username=:username";
		Query query = session.createQuery(queryString);
		query.setString("username", username); 
		Object object = query.uniqueResult();
		
		User user = (User) object;
		
		List<Address> profileAddress = new ArrayList<>();
		for(Address address:user.getAddresses()){
			
			if(address.getAddressInfo()!=null && address.getAddressInfo().equalsIgnoreCase("profileAddress")){
				profileAddress.add(address);
			}
		}
		
		session.close();
		
		return profileAddress;
	}

	@Override
	public void addAddress(Address address) {
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(address);
		
		tx.commit();
		session.close();
	}

	@Override
	public List<Trip> getTripsForNextWeek() {
		Session session = this.sessionFactory.openSession();
		
		String queryString = "from User where type_of_user=:typeOfUser";
		Query query = session.createQuery(queryString);
		query.setString("typeOfUser", "driver"); 
		
		List<User> user = query.list();
		
		session.close();
		List<Trip> tripsList = new ArrayList<>();
		
		for(User u:user){
			
			List<Trip> tripList = u.getTrips(); 
			
			for(Trip t:tripList){
				java.util.Date startTime = t.getTimeOfTravel();
				Date date = new Date();
				
				if(t.getTripStatus()!=null && t.getTripStatus().equals(Status.CONFIRMED.toString()))
					continue;
				
				Calendar c = Calendar.getInstance();
			    c.setTime(date);
			    c.add(Calendar.WEEK_OF_MONTH, 1);
				
			    Date date2 = c.getTime();
			    
				if(startTime.after(date) && startTime.before(date2)){
					tripsList.add(t);
				}
			}
		}		
		
		
		return tripsList;
	}
	
	
	
	

}
