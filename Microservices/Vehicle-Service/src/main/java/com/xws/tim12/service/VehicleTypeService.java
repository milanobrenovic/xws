package com.xws.tim12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.dto.VehicleTypeDTO;
import com.xws.tim12.model.VehicleType;
import com.xws.tim12.repository.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;

	public VehicleTypeService() {}
	
	public VehicleType findOne(Long id) {
		return vehicleTypeRepository.findOneById(id);
	}
	
	public List<VehicleType> findAll(){
		return vehicleTypeRepository.findAll();
	}
	
	public VehicleType save(VehicleType vehicleType) {
		return vehicleTypeRepository.save(vehicleType);
	}
	
	public VehicleType convertFromDTO(VehicleTypeDTO vehicleTypeDTO) {
		return  new VehicleType(vehicleTypeDTO.getType());
	}
}
