package com.xws.tim12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.model.TransportationVehicle;

public interface TransportationVehicleRepository extends JpaRepository<TransportationVehicle,Long>{
	List<TransportationVehicle> findAll();
	TransportationVehicle findOneById(Long id);
}
