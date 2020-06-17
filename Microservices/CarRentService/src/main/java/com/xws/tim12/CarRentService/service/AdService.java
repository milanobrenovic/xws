package com.xws.tim12.CarRentService.service;


import java.time.LocalDateTime;
import java.util.List;

import com.xws.tim12.CarRentService.dto.AdDTO;

public interface AdService {

    AdDTO create(AdDTO adDTO);

    List<AdDTO> findAll();

    List<AdDTO> findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(
            String pickupLocation, LocalDateTime pickupFrom, LocalDateTime pickupTo);

}
