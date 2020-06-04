package com.xws.tim12.CarRentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.CarRentService.model.RequestToRent;

public interface RequestToRentRepository extends JpaRepository<RequestToRent, Long> {

}
