package com.xws.tim12.CarRentService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.CarRentService.model.VehicleUser;
import com.xws.tim12.CarRentService.repository.VehicleUserRepository;
import com.xws.tim12.CarRentService.service.VehicleUserService;

@Service
public class VehicleUserServiceImpl implements VehicleUserService{
	
	@Autowired
	private VehicleUserRepository vehicleUserRepository;

	@Override
	public VehicleUser findById(Long id) {
		if(vehicleUserRepository.findOneById(id) == null) {
			return null;
		}
		
		return vehicleUserRepository.findOneById(id);
	}
}
