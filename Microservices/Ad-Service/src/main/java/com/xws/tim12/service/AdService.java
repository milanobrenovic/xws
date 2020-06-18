package com.xws.tim12.service;

import com.xws.tim12.dto.AdDTO;
import com.xws.tim12.model.Ad;

import java.time.LocalDateTime;
import java.util.List;

public interface AdService {

    AdDTO create(AdDTO adDTO);

    List<AdDTO> findAll();

    List<AdDTO> findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(
            String pickupLocation, LocalDateTime pickupFrom, LocalDateTime pickupTo);
    
    Ad findById(Long id);
}
