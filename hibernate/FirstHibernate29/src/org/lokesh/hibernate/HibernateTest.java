package org.lokesh.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.lokesh.dto.Address;
import org.lokesh.dto.FourWheeler;
import org.lokesh.dto.TwoWheeler;
import org.lokesh.dto.UserDetails;
import org.lokesh.dto.Vehicle;


public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Step 2 is, create a session
		
		Session session = sessionFactory.openSession();		
		// start transaction
		session.beginTransaction();
		
		for(int i = 0;i < 13; i++){
			UserDetails user = new UserDetails();
			user.setUserName("User "+i);
			
			session.save(user);
		}
		
		session.getTransaction().commit();
		
		session.close();
		
		// Pull data using criteria
		
		session = sessionFactory.openSession();		
		// start transaction
		session.beginTransaction();
		
		// first level caching on session level
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 5);
		
		// It will not pull the data from database
		// because of first level caching
		UserDetails user1 = (UserDetails) session.get(UserDetails.class, 5);
		
		session.getTransaction().commit();
		
		session.close();

		session = sessionFactory.openSession();		
		// start transaction
		session.beginTransaction();
		
		// first level caching on session level
		
		
		// It will pull the data from database
		// because of second level caching is not enabled
		UserDetails user3 = (UserDetails) session.get(UserDetails.class, 5);
		
		session.getTransaction().commit();
		
		session.close();

		
	}

}
