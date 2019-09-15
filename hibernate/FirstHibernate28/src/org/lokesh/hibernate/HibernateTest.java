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
		
		// we will use here criteria
		// Some times HQL query will become complex
		// so we will use criteria
		// By using aProjections we can use mathematical formulas
		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.setProjection(Projections.property("userId"));
		
		@SuppressWarnings("unchecked")
		List<Integer> users = (List<Integer>) criteria.list();
		
		session.getTransaction().commit();
		
		session.close();
		
		for(int u : users){
			System.out.println(u);
		}
		
		
		UserDetails exampleUser = new UserDetails();
		
		exampleUser.setUserId(5);// Example ignores two thing First is null property
								// second is Primary key
		exampleUser.setUserName("User 5");
		
		// Pull data using criteria
		
				session = sessionFactory.openSession();		
				// start transaction
				session.beginTransaction();
				
				// we will use here criteria
				// Some times HQL query will become complex
				// so we will use criteria
				// Here we will use Example
				Example example = Example.create(exampleUser);
				
				criteria = session.createCriteria(UserDetails.class);
				criteria.add(example);
				
				@SuppressWarnings("unchecked")
				List<UserDetails> users1 = (List<UserDetails>) criteria.list();
				
				session.getTransaction().commit();
				
				session.close();
				
				for(UserDetails u : users1){
					System.out.println(u.getUserName());
				}
				
				
				// Here Exclude user as well
				
				session = sessionFactory.openSession();		
				// start transaction
				session.beginTransaction();
				
				// we will use here criteria
				// Some times HQL query will become complex
				// so we will use criteria
				// Here we will use Example
				example = Example.create(exampleUser).excludeProperty("userName");
				
				criteria = session.createCriteria(UserDetails.class);
				criteria.add(example);
				
				@SuppressWarnings("unchecked")
				List<UserDetails> users2 = (List<UserDetails>) criteria.list();
				
				session.getTransaction().commit();
				
				session.close();
				
				for(UserDetails u : users2){
					System.out.println(u.getUserName());
				}
				
				
				
				// Here you can use Like property
				
				exampleUser.setUserName("User 1%");
				session = sessionFactory.openSession();		
				// start transaction
				session.beginTransaction();
				
				// we will use here criteria
				// Some times HQL query will become complex
				// so we will use criteria
				// Here we will use Example
				example = Example.create(exampleUser).enableLike();
				
				criteria = session.createCriteria(UserDetails.class);
				criteria.add(example);
				
				@SuppressWarnings("unchecked")
				List<UserDetails> users3 = (List<UserDetails>) criteria.list();
				
				session.getTransaction().commit();
				
				session.close();
				
				for(UserDetails u : users3){
					System.out.println(u.getUserName());
				}
				
		
	}

}
