package com.xws.tim12.CarRentService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ServiceReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private VehicleUser vehicleUser;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private VehicleRenter vehicleRenter;
	
	private int stars;
	
	private String description;
	

	
	public ServiceReview() {
		super();
	}
	
	public ServiceReview(Long id, VehicleUser vehicleUser, VehicleRenter vehicleRenter, int stars, String description) {
		super();
		this.id = id;
		this.vehicleUser = vehicleUser;
		this.vehicleRenter = vehicleRenter;
		this.stars = stars;
		this.description = description;
	}
	
	public ServiceReview(Long id, VehicleUser vehicleUser, VehicleRenter vehicleRenter, int stars) {
		super();
		this.id = id;
		this.vehicleUser = vehicleUser;
		this.vehicleRenter = vehicleRenter;
		this.stars = stars;
		this.description = "";
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VehicleUser getVehicleUser() {
		return vehicleUser;
	}

	public void setVehicleUser(VehicleUser vehicleUser) {
		this.vehicleUser = vehicleUser;
	}

	public VehicleRenter getVehicleRenter() {
		return vehicleRenter;
	}

	public void setVehicleRenter(VehicleRenter vehicleRenter) {
		this.vehicleRenter = vehicleRenter;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@Override
	public String toString() {
		return "ServiceReview [id=" + id + ", vehicleUser=" + vehicleUser + ", vehicleRenter=" + vehicleRenter
				+ ", stars=" + stars + ", description=" + description + "]";
	}
	
	
}
