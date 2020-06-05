package com.xws.tim12.CarRentService.service;

import java.util.Optional;

import com.xws.tim12.CarRentService.model.Vehicle;

public interface VehicleService {
	
	Vehicle findById(Long id);
}
