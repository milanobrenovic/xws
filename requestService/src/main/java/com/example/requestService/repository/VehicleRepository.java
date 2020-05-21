package com.example.requestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.requestService.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	
	Vehicle findOneById(Long id);
	Vehicle findOneByModel(String model);
}
