package com.xws.tim12.CarRentService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.CarRentService.model.VehicleRenter;
import com.xws.tim12.CarRentService.repository.VehicleRenterRepository;
import com.xws.tim12.CarRentService.service.VehicleRenterService;

@Service
public class VehicleRenterServiceImpl implements VehicleRenterService{
	
	@Autowired
	private VehicleRenterRepository vehicleRenterRepository;

	@Override
	public VehicleRenter findById(Long id) {
		if(vehicleRenterRepository.findOneById(id) == null) {
			return null;
		}
		
		return vehicleRenterRepository.findOneById(id);
	}
	
	
}
