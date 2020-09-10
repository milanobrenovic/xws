package com.xws.tim12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.model.TransportationVehicle;
import com.xws.tim12.repository.TransportationVehicleRepository;

@Service
public class TransportationVehicleService {
	@Autowired
	private TransportationVehicleRepository transportationVehicleRepository;
	
	public List<TransportationVehicle> findAll(){
		return transportationVehicleRepository.findAll();
	}
	
	public TransportationVehicle findById(Long id) {
		return transportationVehicleRepository.findOneById(id);
	}
	
	
}
