package org.lokesh.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// It will show complete Entity name
@Entity(name="USER_DETAILS")
public class UserDetails {
	
	//@Id represent primary key
	// here userId is primary key
	// If you want to AutoGenerate the serogate Key then You can Use @GeneratedValue, It will increment Automatically
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;
	
	//Set of object saving as Different table
	@ElementCollection
	private Set<Address> listOfAddress = new HashSet<>(); 
	
	
	
	public Set<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Set<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
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
