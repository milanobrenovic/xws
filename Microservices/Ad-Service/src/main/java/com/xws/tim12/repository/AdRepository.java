package com.xws.tim12.repository;

import com.xws.tim12.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {

    List<Ad> findAll();
    Ad findOneById(Long id);

    List<Ad> findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(
            String pickupLocation, Date pickupFrom, Date pickupTo);

}
