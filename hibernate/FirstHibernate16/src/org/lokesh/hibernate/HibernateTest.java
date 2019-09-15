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
		
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("First User Vehicle");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setSteeringHandle("Two Wheeler Steering");
		twoWheeler.setVehicleName("Two Wheeler");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setSteeringWheel("Four Wheeler Steering");
		fourWheeler.setVehicleName("Four Wheeler");
		
		
		// we have to follow three step
		//step 1 is, create sessionFactory
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		// Step 2 is, create a session
		
		Session session = sessionFactory.openSession();
		
		// start transaction
		session.beginTransaction();
		//save the model Object into Session
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		// commit the data to the database
		session.getTransaction().commit();
		
		session.close();
		
	}

}
