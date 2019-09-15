package org.lokesh.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// It will show complete Entity name
@Entity(name="USER_DETAILS")
public class UserDetails {
	
	//@Id represent primary key
	// here userId is primary key
	@Id
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;
	
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
