package com.driveanddeliver.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
		
		return user;
		

	}

}
