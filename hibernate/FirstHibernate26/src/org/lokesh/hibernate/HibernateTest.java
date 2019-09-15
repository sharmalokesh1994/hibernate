package org.lokesh.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
		
		for(int i = 0;i < 10; i++){
			UserDetails user = new UserDetails();
			user.setUserName("User "+i);
			
			session.save(user);
		}
		
		session.getTransaction().commit();
		
		session.close();
		
		// HQL Queries
		
		session = sessionFactory.openSession();		
		// start transaction
		session.beginTransaction();
		
		// we can use named query
		// the name will be same as kept in UserDetails class
		Query query = session.getNamedQuery("UserDetails.ByID");
		query.setInteger(0, 2);
		
		@SuppressWarnings("unchecked")
		List<UserDetails> users = (List<UserDetails>) query.list();
		
		session.getTransaction().commit();
		
		session.close();
		
		for(UserDetails u : users){
			System.out.println(u.getUserName());
		}
		
		
		// for sql or second query, you should avoid sql
		session = sessionFactory.openSession();		
		// start transaction
		session.beginTransaction();
		
		// we can use named query
		// the name will be same as kept in UserDetails class
		query = session.getNamedQuery("UserDetails.ByUserName");
		query.setString(0, "User 9");
		
		@SuppressWarnings("unchecked")
		List<UserDetails> users1 = (List<UserDetails>) query.list();
		
		session.getTransaction().commit();
		
		session.close();
		
		for(UserDetails u : users1){
			System.out.println(u.getUserName());
		}
		
		
	}

}
