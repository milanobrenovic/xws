package com.xws.tim12.CarRentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.CarRentService.model.VehicleRenter;

public interface VehicleRenterRepository extends JpaRepository<VehicleRenter, Long> {

}
