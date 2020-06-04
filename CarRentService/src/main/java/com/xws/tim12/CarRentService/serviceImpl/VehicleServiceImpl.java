package com.xws.tim12.CarRentService.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.CarRentService.model.Vehicle;
import com.xws.tim12.CarRentService.repository.VehicleRepository;
import com.xws.tim12.CarRentService.service.VehicleService;

@Service	
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	
	@Override
	public Vehicle findById(Long id) {
		if(vehicleRepository.findOneById(id) == null) {
			return null;
		}
		
		return vehicleRepository.findOneById(id);
	}
	
}
