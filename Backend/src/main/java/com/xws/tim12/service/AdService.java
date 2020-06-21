package com.xws.tim12.service;

import java.util.Date;
import java.util.List;

import com.xws.tim12.dto.AdDTO;

public interface AdService {

    AdDTO create(AdDTO adDTO);

    List<AdDTO> findAll();

    List<AdDTO> findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(
            String pickupLocation, Date pickupFrom, Date pickupTo);

}
