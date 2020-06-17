package com.xws.tim12.CarRentService.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VehicleRenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//id Usera/Agenta koji iznajmljuje
	private Long idUserRenter;
	
	@JsonIgnore
	@OneToMany(mappedBy="vehicleRenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Vehicle> vehicles = new HashSet<Vehicle>();
	
	
	@JsonIgnore
	@OneToMany(mappedBy="vehicleRenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<RequestToRent> requests = new HashSet<RequestToRent>();
	
	@JsonIgnore
	@OneToMany(mappedBy="vehicleRenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ServiceReview> serviceReviews = new HashSet<ServiceReview>();

	
	public VehicleRenter() {
		super();
	}
	
	public VehicleRenter(Long id, Long idUserRenter, Set<Vehicle> vehicles, Set<RequestToRent> requests,
			Set<ServiceReview> serviceReviews) {
		super();
		this.id = id;
		this.idUserRenter = idUserRenter;
		this.vehicles = vehicles;
		this.requests = requests;
		this.serviceReviews = serviceReviews;
	}
	
	
	public VehicleRenter(Long id, Long idUserRenter, Set<Vehicle> vehicles) {
		super();
		this.id = id;
		this.idUserRenter = idUserRenter;
		this.vehicles = vehicles;
		this.requests = new HashSet<>();
		this.serviceReviews = new HashSet<>();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<RequestToRent> getRequests() {
		return requests;
	}

	public void setRequests(Set<RequestToRent> requests) {
		this.requests = requests;
	}

	public Long getIdUserRenter() {
		return idUserRenter;
	}

	public void setIdUserRenter(Long idUserRenter) {
		this.idUserRenter = idUserRenter;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}


	public Set<ServiceReview> getServiceReviews() {
		return serviceReviews;
	}

	public void setServiceReviews(Set<ServiceReview> serviceReviews) {
		this.serviceReviews = serviceReviews;
	}

	@Override
	public String toString() {
		return "VehicleRenter [id=" + id + ", idUserRenter=" + idUserRenter + ", vehicles=" + vehicles + ", requests="
				+ requests + ", serviceReviews=" + serviceReviews + "]";
	}
	
	
	
}
