package com.xws.tim12.CarRentService.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cart {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long userId;
	
	@JsonIgnore
	/*@ManyToMany(mappedBy = "cart")*/
	private ArrayList<Long> vehicles ;
	
	public Cart() {
		
	}
	
	public Cart(Long userId, ArrayList<Long> vehicles) {
		//super();
		this.userId = userId;
		this.vehicles = vehicles;
	}
	
	public Cart(Long userId) {
		//super();
		this.userId = userId;
		this.vehicles = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<Long> getVehicles() {
		return vehicles;
	}

	public void setVehicles(ArrayList<Long> vehicles) {
		this.vehicles = vehicles;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", vehicles=" + vehicles + "]";
	}
	

}
