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
				
				Query query = session.createQuery("FROM USER_DETAILS");
				
				// You can paginate here
				
				query.setFirstResult(5);//hibernate will start reading from 5
				query.setMaxResults(4);//Only 4 user will be read by Hibernate from Users
				
				@SuppressWarnings("unchecked")
				List<UserDetails> users = (List<UserDetails>) query.list();
				
				session.getTransaction().commit();
				
				session.close();
				
				for(UserDetails u : users){
					System.out.println(u.getUserName());
				}		
		
	}

}
