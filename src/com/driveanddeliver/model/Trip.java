package com.driveanddeliver.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Amandeep Singh Dhammu
 *
 */

@Entity
@Table(name="Trip")
public class Trip {

	@Id
	@Column(name="trip_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="trip", cascade = CascadeType.ALL)
	private List<Address> address;
	
	@Column(name="time_of_travel")
	private Date timeOfTravel;	
	
	@OneToOne(mappedBy="trip",cascade = CascadeType.ALL)
	private Car car;
	
	@ManyToOne
	@JoinColumn(name="trip_user_id")
	private User user;
	
	@Column(name="trip_status")
	private String tripStatus;
	
	@OneToOne
	@JoinColumn(name="package_trip_id")
	private MyPackage myPackage;
	
	@OneToOne(mappedBy="tripId",cascade=CascadeType.ALL)
	private MyPackage myPackage2;
	
	public Trip() {
		// TODO Auto-generated constructor stub
	}
	
	public Trip(User user) {
		this.user = user;
	}
	
	public Trip(User user,Car car) {
		this.user = user;
		this.car = car;
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

	public Date getTimeOfTravel() {
		return timeOfTravel;
	}

	public void setTimeOfTravel(Date timeOfTravel) {
		this.timeOfTravel = timeOfTravel;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String status) {
		this.tripStatus = status;
	}

	public MyPackage getMyPackage() {
		return myPackage;
	}

	public void setMyPackage(MyPackage myPackage) {
		this.myPackage = myPackage;
	}

	public MyPackage getMyPackage2() {
		return myPackage2;
	}

	public void setMyPackage2(MyPackage myPackage2) {
		this.myPackage2 = myPackage2;
	}
	
	
}
