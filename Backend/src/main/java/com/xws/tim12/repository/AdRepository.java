package com.xws.tim12.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.model.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {

    List<Ad> findAll();

    List<Ad> findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(
            String pickupLocation, LocalTime pickupFrom, LocalTime pickupTo);

}
