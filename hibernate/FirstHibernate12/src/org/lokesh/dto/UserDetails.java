package org.lokesh.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

// It will show complete Entity name
@Entity(name="USER_DETAILS")
public class UserDetails {
	
	//@Id represent primary key
	// here userId is primary key
	// If you want to AutoGenerate the serogate Key then You can Use @GeneratedValue, It will increment Automatically
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;
	
	// It will create new Table and keep default name but if we want to stop it then we have to use jointable anotation
	@ManyToMany
	private Collection<Vehicle> vehicleList = new ArrayList<>();
	
	
	public Collection<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(Collection<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
