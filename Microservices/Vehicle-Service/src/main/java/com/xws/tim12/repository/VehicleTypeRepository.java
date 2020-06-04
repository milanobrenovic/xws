package com.xws.tim12.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.model.VehicleType;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long>{

	VehicleType findOneById(Long id);
	
	VehicleType findByType(String type);
}
