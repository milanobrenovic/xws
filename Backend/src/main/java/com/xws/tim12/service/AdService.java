package com.xws.tim12.service;

import com.xws.tim12.dto.AdDTO;

import java.time.LocalTime;
import java.util.List;

public interface AdService {

    AdDTO create(AdDTO adDTO);

    List<AdDTO> findAll();

    List<AdDTO> findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(
            String pickupLocation, LocalTime pickupFrom, LocalTime pickupTo);

}
