package com.xws.tim12.CarRentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.CarRentService.model.VehicleUser;

public interface VehicleUserRepository extends JpaRepository<VehicleUser, Long> {

}
