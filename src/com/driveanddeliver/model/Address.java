package com.driveanddeliver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Amandeep Singh Dhammu
 *
 */

@Entity
@Table(name="Address")
public class Address {
	
	@Id
	@Column(name="address_id")
	@GeneratedValue
	private int id;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="phone_number")
	private String phoneNo;
	
	@Column(name="pin_code")
	private String poBox;	
	
	@Column(name="type_of_Address")
	private String typeOfAddress;
	
	@ManyToOne
	@JoinColumn(name="address_user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="trip_address_id")
	private Trip trip;
	
	@ManyToOne
	@JoinColumn(name="package_address_id")
	private MyPackage myPackage;
	
	@Column(name="country")
	private String country;
	
	@Column(name="address_info")
	private String addressInfo;
	
	public Address() {
		
	}
	
	public Address(User user){
		this.user = user;
	}
	
	public Address(User user,Trip trip) {
		this.user = user;		
		this.trip = trip;		
	}


	public Address(User user,MyPackage myPackage) {
		this.user = user;
		this.myPackage = myPackage;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPoBox() {
		return poBox;
	}

	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}

	public String getTypeOfAddress() {
		return typeOfAddress;
	}

	public void setTypeOfAddress(String typeOfAddress) {
		this.typeOfAddress = typeOfAddress;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
