package com.xws.tim2.CartService.service;


import java.time.LocalDateTime;
import java.util.List;

import com.xws.tim2.CartService.dto.AdDTO;

public interface AdService {

    AdDTO create(AdDTO adDTO);

    List<AdDTO> findAll();

    List<AdDTO> findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(
            String pickupLocation, LocalDateTime pickupFrom, LocalDateTime pickupTo);

}
