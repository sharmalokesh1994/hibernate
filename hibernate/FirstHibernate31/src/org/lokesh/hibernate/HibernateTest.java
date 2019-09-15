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
		// If you don't want to pull query again
		// you have to enable query cache
		
		Query query = session.createQuery("from USER_DETAILS");
		query.setCacheable(true);// if you will not do this query cache will not work or enable
		List users = query.list();
		
		session.getTransaction().commit();
		
		session.close();

		session = sessionFactory.openSession();		
		// start transaction
		session.beginTransaction();
		
		Query query1 = session.createQuery("from USER_DETAILS");
		query1.setCacheable(true);// if you will not do this query cache will not work or enable
		List users1 = query1.list();
		
		session.getTransaction().commit();
		
		session.close();

		
	}

}
