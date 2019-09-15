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
		
		
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		
		// till now user object is Transient Because It is not being hand over to the Hibernate
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Step 2 is, create a session
		
		Session session = sessionFactory.openSession();		
		// start transaction
		session.beginTransaction();
		
		//It has become persistent
		session.save(user);
		
		// the changes in user will also get updated in Database by hibernate
		// before commit and closing the session
		user.setUserName("First User Changed");
		
		session.getTransaction().commit();
		
		session.close();
		
		// After closing the session it will become Detached
		// Now no change will be updated in Database
		
		user.setUserName("First User Changed Again");
		
	}

}
