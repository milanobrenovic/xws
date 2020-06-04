package com.xws.tim12.CarRentService.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xws.tim12.CarRentService.enumeration.RequestStatusType;

@Entity
public class RequestToRent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "requestsToRent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Vehicle> vehicles = new HashSet<Vehicle>();
	
	//User koji koristi vozilo
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private VehicleUser vehicleUser;
	
	//Renter kao User/Agent koji iznajmljuje vozilo
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private VehicleRenter vehicleRenter;

	
	private RequestStatusType status;
	
	
	
	public RequestToRent() {
		super();
	}

	public RequestToRent(Long id, Set<Vehicle> vehicles, VehicleUser vehicleUser, VehicleRenter vehicleRenter,
			RequestStatusType status) {
		super();
		this.id = id;
		this.vehicles = vehicles;
		this.vehicleUser = vehicleUser;
		this.vehicleRenter = vehicleRenter;
		this.status = status;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RequestStatusType getStatus() {
		return status;
	}

	public void setStatus(RequestStatusType status) {
		this.status = status;
	}
	
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
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

	@Override
	public String toString() {
		return "RequestToRent [id=" + id + ", vehicles=" + vehicles + ", vehicleUser=" + vehicleUser
				+ ", vehicleRenter=" + vehicleRenter + ", status=" + status + "]";
	}

	
}
