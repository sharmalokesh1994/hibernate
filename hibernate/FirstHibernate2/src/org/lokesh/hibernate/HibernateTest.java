package org.lokesh.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lokesh.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		user.setAddress("First User Address");
		user.setDate(new Date());
		user.setDescription("First User Description");
		
		
		// we have to follow three step
		//step 1 is, create sessionFactory
		// Seesion Factory will be created only once because it is a huge object
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session=null;
		try{
			// Step 2 is, create a session
			
			session = sessionFactory.openSession();
			
			// start transaction
			session.beginTransaction();
			//save the model Object into Session
			session.save(user);
			// commit the data to the database
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		
		user =null;
		try{
			
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			// session.get(class Name, primaryKey)
			user = (UserDetails)session.get(UserDetails.class, 1);
			
			
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		
		System.out.println("User Retriveed from Database : "+user.getAddress());

	}

}
