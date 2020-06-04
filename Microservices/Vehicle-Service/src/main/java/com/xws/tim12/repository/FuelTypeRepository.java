package com.xws.tim12.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.model.FuelType;

public interface FuelTypeRepository extends JpaRepository<FuelType, Long>{

	FuelType findOneById(Long id);
	
	FuelType findByType(String type);
}
