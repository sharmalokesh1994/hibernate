package org.lokesh.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
	
	// it will embedded the object
	@Embedded
	//@AttributeOverirde is useful to override Attribute name in main Entity
	@AttributeOverrides({
		@AttributeOverride(name="streat",column= @Column(name="HOME_STREET_NAME")),
		@AttributeOverride(name="city",column= @Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name="state",column= @Column(name="HOME_STATE_NAME")),
		@AttributeOverride(name="pincode",column= @Column(name="HOME_PINCODE")),
	})
	private Address homeAddress; 
	
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
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	
}
