package com.driveanddeliver.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.driveanddeliver.model.User;

public class DriverDAOImpl extends UserDAOImpl implements DriverDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User getDriverDetails(String email) {
		Session session = this.sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		String queryString = "from User where emailId=:emailId";
		Query query = session.createQuery(queryString);
		query.setString("emailId", email); 
		Object object = query.uniqueResult();
		
		User user = (User) object;
		
		transaction.commit();
		
		return user;
	}

}
