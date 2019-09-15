package org.lokesh.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

// It will show complete Entity name
@Entity

// For table name only
@Table (name = "USER_DETAILS")
public class UserDetails {
	
	//@Id represent primary key
	// here userId is primary key
	@Id
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;
	
	
	
	// Description can be too much long so we will use @LOB, LOB means Large Object
	@Column(name = "DESCRIPTION")
	@Lob
	private String description;
	
	// for selecting Special kind of time so @Temporal will be used
	@Column(name="DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name = "ADDRESS")
	private String address;
	
	
	// These two below property will not create in Database
	
	//static variable will not create in Database
	private static String HibernateDoNotCreateInDATABASE1;
	//@Transient property ignores the variable(That varable will not save in database)
	@Transient
	private String HibernateDoNotCreateInDATABASE2;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public static String getHibernateDoNotCreateInDATABASE1() {
		return HibernateDoNotCreateInDATABASE1;
	}
	public static void setHibernateDoNotCreateInDATABASE1(String hibernateDoNotCreateInDATABASE1) {
		HibernateDoNotCreateInDATABASE1 = hibernateDoNotCreateInDATABASE1;
	}
	public String getHibernateDoNotCreateInDATABASE2() {
		return HibernateDoNotCreateInDATABASE2;
	}
	public void setHibernateDoNotCreateInDATABASE2(String hibernateDoNotCreateInDATABASE2) {
		HibernateDoNotCreateInDATABASE2 = hibernateDoNotCreateInDATABASE2;
	}
	
	
}
