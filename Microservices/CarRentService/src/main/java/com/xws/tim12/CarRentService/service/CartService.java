package com.xws.tim12.CarRentService.service;

import java.util.ArrayList;
import java.util.Set;

import com.xws.tim12.CarRentService.dto.CartDTO;
import com.xws.tim12.CarRentService.model.Cart;



public interface CartService {
	
	Cart findById(Long id);
	
	CartDTO createCart(CartDTO cart);
	Cart findByUserId(Long id);
	
	void removeVehicleFromCart(Long vehicle, Long id);
	
	ArrayList<Long> getAllCartVehicles(Long id);
	
	CartDTO addVehicleToCart(Long id, Long id2);
}
