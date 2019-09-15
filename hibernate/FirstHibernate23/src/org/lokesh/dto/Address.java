package org.lokesh.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// It is value object it will embedded into old table
@Embeddable
public class Address {

	@Column(name="STREAT_NAME")
	private String streat;
	@Column(name="CITY_NAME")
	private String city;
	@Column(name="STATE_NAME")
	private String state;
	@Column(name="PINCODE")
	private String pincode;
	public String getStreat() {
		return streat;
	}
	public void setStreat(String streat) {
		this.streat = streat;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
