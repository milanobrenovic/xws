package com.xws.tim12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

	Vehicle findOneById(Long id);
	List<Vehicle> findAllByIdOwner(Long idOwner);
	
}
