package com.driveanddeliver.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "package")
public class MyPackage {
	
	@Id
	@Column(name="package_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	@OneToMany(mappedBy="myPackage", cascade = CascadeType.ALL)
	private List<Address> address;
	
	@Column(name="pickup_date")
	private Date pickupDate;	
	
	@ManyToOne
	@JoinColumn(name="package_user_id")
	private User user;
	
	@Column(name="width")
	private float width;
	
	@Column(name="length")
	private float length;
	
	@Column(name="height")
	private float height;
	
	public MyPackage() {
	}

	public MyPackage(User user) {
		this.user = user;
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
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	
	public float getWidth() {
		return this.width;
	}
	
	public void setWidth(float width) {
		this.width = width;
	}
	
	public float getHeight() {
		return this.height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	public float getLength() {
		return this.length;
	}
	
	public void setLength(float length) {
		this.length = length;
	}
	
	public Date getPickupDate() {
		return this.pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}
	
}
