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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VehicleUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//id Usera/Agenta koji koristi vozilo
	private Long idUser;
		
	
	@JsonIgnore
	@OneToMany(mappedBy="vehicleUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<RequestToRent> requsets = new HashSet<RequestToRent>();
	
	@JsonIgnore
	@OneToMany(mappedBy="vehicleUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ServiceReview> serviceReviews = new HashSet<ServiceReview>();

	
	
	public VehicleUser() {
		
		super();
		
	}
	
	
	
	public VehicleUser(Long id, Long idUser, 
			Set<RequestToRent> requsets, Set<ServiceReview> serviceReviews) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.requsets = requsets;
		this.serviceReviews = serviceReviews;
	}
	
	public VehicleUser(Long id, Long idUser) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.requsets = new HashSet<>();
		this.serviceReviews = new HashSet<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	
	
	public Set<ServiceReview> getServiceReviews() {
		return serviceReviews;
	}

	public void setServiceReviews(Set<ServiceReview> serviceReviews) {
		this.serviceReviews = serviceReviews;
	}
	


	public Set<RequestToRent> getRequsets() {
		return requsets;
	}

	public void setRequsets(Set<RequestToRent> requsets) {
		this.requsets = requsets;
	}



	@Override
	public String toString() {
		return "VehicleUser [id=" + id + ", idUser=" + idUser + ", requsets=" + requsets + ", serviceReviews="
				+ serviceReviews + "]";
	}



	
	
	
}
