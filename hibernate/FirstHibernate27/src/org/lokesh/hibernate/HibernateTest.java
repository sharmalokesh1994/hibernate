package org.lokesh.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
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
		
		for(int i = 0;i < 10; i++){
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
		
		// we will use here criteria
		// Some times HQL query will become complex
		// so we will use criteria
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("userName", "User 9"));
		
		@SuppressWarnings("unchecked")
		List<UserDetails> users = (List<UserDetails>) criteria.list();
		
		session.getTransaction().commit();
		
		session.close();
		
		for(UserDetails u : users){
			System.out.println(u.getUserName());
		}
		
		
				// Pull data using criteria
		
				session = sessionFactory.openSession();		
				// start transaction
				session.beginTransaction();
				
				// we will use here criteria
				// Some times HQL query will become complex
				// so we will use criteria
				criteria = session.createCriteria(UserDetails.class);
				criteria.add(Restrictions.ge("userId", 5));
				criteria.add(Restrictions.le("userId", 8));
				
				@SuppressWarnings("unchecked")
				List<UserDetails> users1 = (List<UserDetails>) criteria.list();
				
				session.getTransaction().commit();
				
				session.close();
				
				for(UserDetails u : users1){
					System.out.println(u.getUserName());
				}
				
				
				// Pull data using criteria
				
				session = sessionFactory.openSession();		
				// start transaction
				session.beginTransaction();
				
				// we will use here criteria
				// Some times HQL query will become complex
				// so we will use criteria
				criteria = session.createCriteria(UserDetails.class);
				criteria.add(Restrictions.like("userName", "%User%")).
							add(Restrictions.le("userId", 8));
				
				@SuppressWarnings("unchecked")
				List<UserDetails> users2 = (List<UserDetails>) criteria.list();
				
				session.getTransaction().commit();
				
				session.close();
				
				for(UserDetails u : users2){
					System.out.println(u.getUserName());
				}
				
				
				
				// Pull data using criteria
				
				session = sessionFactory.openSession();		
				// start transaction
				session.beginTransaction();
				
				// we will use here criteria
				// Some times HQL query will become complex
				// so we will use criteria
				criteria = session.createCriteria(UserDetails.class);
				criteria.add(Restrictions.or(Restrictions.ge("userId", 7), Restrictions.le("userId", 3)));
				
				@SuppressWarnings("unchecked")
				List<UserDetails> users3 = (List<UserDetails>) criteria.list();
				
				session.getTransaction().commit();
				
				session.close();
				
				for(UserDetails u : users3){
					System.out.println(u.getUserName());
				}
		
		
				// Pull data using criteria
				
				session = sessionFactory.openSession();		
				// start transaction
				session.beginTransaction();
				
				// we will use here criteria
				// Some times HQL query will become complex
				// so we will use criteria
				criteria = session.createCriteria(UserDetails.class);
				criteria.addOrder(Order.desc("userId"));
				
				@SuppressWarnings("unchecked")
				List<UserDetails> users4 = (List<UserDetails>) criteria.list();
				
				session.getTransaction().commit();
				
				session.close();
				
				for(UserDetails u : users4){
					System.out.println(u.getUserName());
				}
		
				
		
	}

}
