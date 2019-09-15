package org.lokesh.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lokesh.dto.Address;
import org.lokesh.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetails user = new UserDetails();
		user.setUserName("Firsy User");
		
		Address address = new Address();
		
		address.setStreat("First Streat");
		address.setCity("First City");
		address.setPincode("1234");
		address.setState("state1");
		
		Address address2 = new Address();
		
		address2.setStreat("First Streat2");
		address2.setCity("First City2");
		address2.setPincode("12342");
		address2.setState("state2");
		
		user.getListOfAddress().add(address);
		user.getListOfAddress().add(address2);
		
		
		
		// we have to follow three step
		//step 1 is, create sessionFactory
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Step 2 is, create a session
		
		Session session = sessionFactory.openSession();
		
		// start transaction
		session.beginTransaction();
		//save the model Object into Session
		session.save(user);
		// commit the data to the database
		session.getTransaction().commit();

	}

}
