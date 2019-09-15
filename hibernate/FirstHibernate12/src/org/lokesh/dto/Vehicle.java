package org.lokesh.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity(name = "VEHICLE")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="VEHICLE_ID")
	private int vehicleId;
	@Column(name="VEHICLE_NAME")
	private String vehicleName;
	
	//To avoid two table we will use MappedBy vehicle which is a collection in User
	@ManyToMany(mappedBy="vehile")
	private Collection<UserDetails> userLsit = new ArrayList<>();
	
	public Collection<UserDetails> getUserLsit() {
		return userLsit;
	}
	public void setUserLsit(Collection<UserDetails> userLsit) {
		this.userLsit = userLsit;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	
}
