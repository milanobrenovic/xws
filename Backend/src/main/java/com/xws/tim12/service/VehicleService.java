package com.xws.tim12.service;

import org.springframework.beans.factory.annotation.Autowired;


import com.xws.tim12.model.Vehicle;
import com.xws.tim12.repository.VehicleRepository;



public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Vehicle findOne(Long id){
		return vehicleRepository.findOneById(id);
	}

}
