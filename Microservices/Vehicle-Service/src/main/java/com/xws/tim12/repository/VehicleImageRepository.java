package com.xws.tim12.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.model.VehicleImage;

public interface VehicleImageRepository extends JpaRepository<VehicleImage, Long>{

	VehicleImage findOneById(Long id);

	VehicleImage findByImageName(String imageName);
	
}
