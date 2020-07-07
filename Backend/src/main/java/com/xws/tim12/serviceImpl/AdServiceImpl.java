package com.xws.tim12.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.dto.AdDTO;
import com.xws.tim12.model.Ad;
import com.xws.tim12.repository.AdRepository;
import com.xws.tim12.service.AdService;
import com.xws.tim12.service.VehicleService;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private VehicleService vehicleService;
    
    @Override
    public AdDTO create(AdDTO adDTO) {
        Ad newAd = new Ad(
            vehicleService.findOne(adDTO.getVehicle().getId()),
            adDTO.getComments(),
            adDTO.getPickupLocation(),
            adDTO.getPickupFrom(),
            adDTO.getPickupTo()
        );
        System.out.println("BROJ VOZILA U SISTEMU");
        System.out.println(vehicleService.findAll().size());
        return new AdDTO(adRepository.save(newAd));
    }

    @Override
    public List<AdDTO> findAll() {
        return convertToDTO(adRepository.findAll());
    }

    @Override
    public List<AdDTO> findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(
            String pickupLocation, Date pickupFrom, Date pickupTo) {
        return convertToDTO(adRepository.findByPickupLocationAndPickupFromIsGreaterThanEqualAndPickupToIsGreaterThanEqual(pickupLocation, pickupFrom, pickupTo));
    }

    private List<AdDTO> convertToDTO(List<Ad> ads) {
        if (ads == null || ads.isEmpty()) {
            return new ArrayList<>();
        }

        List<AdDTO> adDTOList = new ArrayList<>();
        for (Ad ad : ads) {
            adDTOList.add(new AdDTO(ad));
        }

        return adDTOList;
    }

    
}
