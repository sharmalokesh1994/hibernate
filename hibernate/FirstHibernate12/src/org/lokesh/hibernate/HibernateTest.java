package org.lokesh.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lokesh.dto.Address;
import org.lokesh.dto.UserDetails;
import org.lokesh.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetails user = new UserDetails();
		user.setUserName("Firsy User");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("First User Vehicle");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle.getUserLsit().add(user);
		vehicle1.getUserLsit().add(user);
		vehicle1.setVehicleName("First User Vehicle");
		
		user.getVehicleList().add(vehicle);
		user.getVehicleList().add(vehicle1);
		
		// we have to follow three step
		//step 1 is, create sessionFactory
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Step 2 is, create a session
		
		Session session = sessionFactory.openSession();
		
		// start transaction
		session.beginTransaction();
		//save the model Object into Session
		session.save(user);
		session.save(vehicle);
		session.save(vehicle1);
		// commit the data to the database
		session.getTransaction().commit();
		
		session.close();
		
	}

}
