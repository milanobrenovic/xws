package com.xws.tim12.CarRentService.service;

import java.util.Set;

import com.xws.tim12.CarRentService.dto.CartDTO;
import com.xws.tim12.CarRentService.model.Cart;
import com.xws.tim12.CarRentService.model.Vehicle;



public interface CartService {
	
	Cart findById(Long id);
	
	CartDTO createCart(CartDTO cart);
	
	void removeVehicleFromCart(Vehicle vehicle, Long id);
	
	Set<Vehicle> getAllCartVehicles(Long id);
	
	CartDTO addVehicleToCart(Long id, Long id2);
}
