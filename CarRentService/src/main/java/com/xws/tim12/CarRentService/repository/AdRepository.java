package com.xws.tim12.CarRentService.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.CarRentService.model.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {

    List<Ad> findAll();

    List<Ad> findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(
            String pickupLocation, LocalDateTime pickupFrom, LocalDateTime pickupTo);

}
