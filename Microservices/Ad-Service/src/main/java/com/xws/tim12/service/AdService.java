package com.xws.tim12.service;

import com.xws.tim12.dto.AdDTO;
import com.xws.tim12.model.Ad;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface AdService {

    AdDTO create(AdDTO adDTO);

    List<AdDTO> findAll();

    List<AdDTO> findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(
            String pickupLocation, Date pickupFrom, Date pickupTo);
    
    Ad findById(Long id);
}
