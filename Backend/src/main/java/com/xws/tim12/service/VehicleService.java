package com.xws.tim12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.dto.VehicleDTO;
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

	public List<Vehicle> findAll(){
		return vehicleRepository.findAll();
	}
	
	public Vehicle convertFromDTO(VehicleDTO vehicleDTO) {
		
		Vehicle vehicle = new Vehicle(vehicleDTO.getBrand(), vehicleDTO.getModel(), vehicleDTO.getFuelType(), vehicleDTO.getTransmissionType(), vehicleDTO.getVehicleType(), vehicleDTO.getPrice(), vehicleDTO.getTravelledMileage(), vehicleDTO.getPlannedMileageToTravel(), vehicleDTO.getIsMileageUnlimited(), vehicleDTO.getHasCollisionDamageWaiver(), vehicleDTO.getNumberOfSeats(), vehicleDTO.getGrade(), vehicleDTO.getAvailable(), vehicleDTO.getVehicleDiscount(), vehicleDTO.getInsurancePrice(), null);
		return vehicle;
	}
	
}
