package com.driveanddeliver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Amandeep Singh Dhammu
 *
 */
@Entity
@Table(name="Car")
public class Car {
	
	@Id
	@Column(name="car_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="make")
	private String make;
	
	@Column(name="model")
	private String model;
	
	@Column(name="car_number")
	private String carNumber;
	
	@Column(name="trunk_area")
	private String trunkArea;
	
	//private User user;
	
	@OneToOne
	@JoinColumn(name="trip_car_id")
	private Trip trip;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	public Car(Trip trip) {
		this.trip = trip;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	/*public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getTrunkArea() {
		return trunkArea;
	}
	public void setTrunkArea(String trunkArea) {
		this.trunkArea = trunkArea;
	}
	
	
	
}
