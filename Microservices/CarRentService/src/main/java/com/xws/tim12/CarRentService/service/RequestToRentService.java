package com.xws.tim12.CarRentService.service;

import java.util.Set;

import com.xws.tim12.CarRentService.dto.RequestToRentDTO;
import com.xws.tim12.CarRentService.model.RequestToRent;

public interface RequestToRentService {
	
	RequestToRent findById(Long id);
	
	RequestToRentDTO createRequest(RequestToRentDTO requestDTO);
	
	RequestToRent addVehicleFromCart(Long id, Long id2);
	
	Set<RequestToRent> addVehiclesFromCart(Long id);
	
}
