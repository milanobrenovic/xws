package com.xws.tim12.CarRentService.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.xws.tim12.CarRentService.model.Cart;

public class CartDTO {
	
	private Long id;
	
	private Long userId;
	
	private ArrayList<Long> vehicles;
	
	
	public CartDTO() {
		super();
	}

	public CartDTO(Long userId) {
		super();
		this.userId = userId;
		this.vehicles = new ArrayList<>();
	}
	
	public CartDTO(Long userId, ArrayList<Long> vehicles) {
		super();
		this.userId = userId;
		this.vehicles = vehicles;
	}
	
	public CartDTO(Long id, Long userId) {
		super();
		this.id = id;
		this.userId = userId;
		this.vehicles = new ArrayList<>();
	}
	
	
	
	public CartDTO(Cart cart) {
		this(cart.getUserId(), cart.getVehicles());
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
