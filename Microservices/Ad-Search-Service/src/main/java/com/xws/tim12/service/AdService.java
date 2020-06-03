package com.xws.tim12.service;

import com.xws.tim12.dto.AdDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface AdService {

    List<AdDTO> findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(
            String pickupLocation, LocalDateTime pickupFrom, LocalDateTime pickupTo);

}
