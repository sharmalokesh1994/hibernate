package org.lokesh.hibernate;

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
		//CURD will happen here only
		
		for(int i=0;i<10;i++){
			UserDetails user = new UserDetails();
			user.setUserName("user "+i);
			session.save(user);
		}
		
		
		session.getTransaction().commit();
		
		session.close();
		
		
		
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
		
		System.out.println(user.getUserName());
		
		session.getTransaction().commit();
		session.close();
		
		
		// for delete
		// we have to get the user
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 6);
		

		session.delete(user);
		
		session.getTransaction().commit();
		
		session.close();
		

		// for update
		// we have to get the user
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 5);
		
		user.setUserName("Updated "+user.getUserName());

		session.update(user);
		
		session.getTransaction().commit();
		
		session.close();

		
		
		
	}

}
