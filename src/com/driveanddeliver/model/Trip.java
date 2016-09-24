package com.driveanddeliver.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private Address startPoint;
	
	private Address endPoint;
	
	private Date  timeOfTravel;
	
	private Car car;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Address startPoint) {
		this.startPoint = startPoint;
	}

	public Address getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Address endPoint) {
		this.endPoint = endPoint;
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
	
	
	
}
