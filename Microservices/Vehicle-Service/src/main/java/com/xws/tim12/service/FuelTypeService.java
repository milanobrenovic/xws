package com.xws.tim12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.dto.FuelTypeDTO;
import com.xws.tim12.model.FuelType;
import com.xws.tim12.repository.FuelTypeRepository;

@Service
public class FuelTypeService {

	@Autowired
	private FuelTypeRepository fuelTypeRepository;
	
	public FuelTypeService() {}
	
	public FuelType findOne(Long id) {
		return fuelTypeRepository.findOneById(id);
	}
	
	public List<FuelType> findAll(){
		return fuelTypeRepository.findAll();
	}
	
	public FuelType save(FuelType fuelType) {
		return fuelTypeRepository.save(fuelType);
	}
	
	public FuelType convertFromDTO(FuelTypeDTO fuelTypeDTO) {
		return  new FuelType(fuelTypeDTO.getType());
	}
}
