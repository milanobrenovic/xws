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

@Entity
public class VehicleUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//id Usera/Agenta koji koristi vozilo
	private Long idUser;
		
	private String name;
	
	private String surname;
	
	private String address;

	private String phone;
	
	
	@OneToMany(mappedBy="vehicleUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<RequestToRent> requsets = new HashSet<RequestToRent>();
	
	@OneToMany(mappedBy="vehicleUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ServiceReview> serviceReviews = new HashSet<ServiceReview>();

	
	
	public VehicleUser() {
		
		super();
		
	}
	
	
	
	public VehicleUser(Long id, Long idUser, String name, String surname, String address, String phone,
			Set<RequestToRent> requsets, Set<ServiceReview> serviceReviews) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
/*		this.requsets = requsets;
		this.serviceReviews = serviceReviews;*/
	}
	
	public VehicleUser(Long id, Long idUser, String name, String surname, String address, String phone) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
/*		this.requsets = new ArrayList<>();
		this.serviceReviews = new ArrayList<>();*/
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/*public List<ServiceReview> getServiceReviews() {
		return serviceReviews;
	}

	public void setServiceReviews(List<ServiceReview> serviceReviews) {
		this.serviceReviews = serviceReviews;
	}*/
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	/*public Set<RequestToRent> getRequsets() {
		return requsets;
	}

	public void setRequsets(Set<RequestToRent> requsets) {
		this.requsets = requsets;
	}



	@Override
	public String toString() {
		return "VehicleUser [id=" + id + ", idUser=" + idUser + ", name=" + name + ", surname=" + surname + ", address="
				+ address + ", phone=" + phone + ", requsets=" + requsets + ", serviceReviews=" + serviceReviews + "]";
	}*/

	
	
}
