package com.xws.tim12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.xws.tim12.model.Vehicle;
import com.xws.tim12.repository.VehicleRepository;


@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public VehicleService(){}
	
	public Vehicle findOne(Long id){
		return vehicleRepository.findOneById(id);
	}
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	public Vehicle findOneByModel(String model){
		return vehicleRepository.findOneByModel(model);
	}

}
