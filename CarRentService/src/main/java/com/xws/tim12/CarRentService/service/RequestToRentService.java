package com.xws.tim12.CarRentService.service;

import com.xws.tim12.CarRentService.dto.RequestToRentDTO;
import com.xws.tim12.CarRentService.model.RequestToRent;

public interface RequestToRentService {
	
	RequestToRent findById(Long id);
	
	RequestToRentDTO createRequest(RequestToRentDTO requestDTO);
	
	RequestToRent addVehicleFromCart(Long id, Long id2);
	
	RequestToRent addVehiclesFromCart(Long id);
	
}
