package com.xws.tim12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.dto.VehicleDTO;
import com.xws.tim12.model.FuelType;
import com.xws.tim12.model.TransmissionType;
import com.xws.tim12.model.Vehicle;
import com.xws.tim12.model.VehicleType;
import com.xws.tim12.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private FuelTypeService fuelTypeService;
	
	@Autowired
	private TransmissionTypeService transmissionTypeService;
	
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	public VehicleService() {}
	
	public Vehicle findOne(Long id) {
		return vehicleRepository.findOneById(id);
	}
	
	public List<Vehicle> findAll(){
		return vehicleRepository.findAll();
	}
	
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	
	public Vehicle convertFromDTO(VehicleDTO vehicleDTO) {
		
		FuelType fuelType = fuelTypeService.findOne(vehicleDTO.getFuelType());
		TransmissionType transmissionType = transmissionTypeService.findOne(vehicleDTO.getTransmissionType());
		VehicleType vehicleType = vehicleTypeService.findOne(vehicleDTO.getVehicleType());
		
		Vehicle vehicle = new Vehicle(vehicleDTO.getBrand(), vehicleDTO.getModel(), fuelType, transmissionType, vehicleType, vehicleDTO.getPrice(), vehicleDTO.getTravelledMileage(), vehicleDTO.getPlannedMileageToTravel(), vehicleDTO.getIsMileageUnlimited(), vehicleDTO.getHasCollisionDamageWaiver(), vehicleDTO.getNumberOfSeats(), vehicleDTO.getGrade(), vehicleDTO.getAvailable(), vehicleDTO.getVehicleDiscount(), vehicleDTO.getInsurancePrice(), null);
		return vehicle;
	}
	
}
