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
				
				
				// HQL Queries
				
				String maxLimit = "5";
				session = sessionFactory.openSession();		
				// start transaction
				session.beginTransaction();
				
				/*
				// here we can put dynamicaly as well
				// this will be called SQL injection, It is not secure
				 // so we use Parmeter binding
				Query query = session.createQuery("FROM USER_DETAILS where USER_ID>"+maxLimit);
				*/
				
				
				/*
				// Parmeter Bindings can be used in two types
				// first one with question marks
				Query query = session.createQuery("FROM USER_DETAILS where USER_ID>? and USER_NAME = ?");
				query.setInteger(0, Integer.parseInt(maxLimit));
				//query.setInteger(Index of question mark, parameter);
				query.setString(1, "User 7");
				
				*/
				
				// Parmeter Bindings can be used in two types
				// second one with : marks
				Query query = session.createQuery("FROM USER_DETAILS where USER_ID>:userId and USER_NAME = :userName");
				query.setInteger("userId", Integer.parseInt(maxLimit));
				//query.setInteger(Index of question mark, parameter);
				query.setString("userName", "User 7");
				
				
				@SuppressWarnings("unchecked")
				List<UserDetails> users = (List<UserDetails>) query.list();
				
				session.getTransaction().commit();
				
				session.close();
				
				for(UserDetails u : users){
					System.out.println(u.getUserName());
				}
		
	}

}
