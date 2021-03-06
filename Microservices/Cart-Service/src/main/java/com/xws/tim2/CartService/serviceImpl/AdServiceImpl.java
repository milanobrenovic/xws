package com.xws.tim2.CartService.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim2.CartService.dto.AdDTO;
import com.xws.tim2.CartService.model.Ad;
import com.xws.tim2.CartService.repository.AdRepository;
import com.xws.tim2.CartService.service.AdService;


@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepository;

    @Override
    public AdDTO create(AdDTO adDTO) {
        Ad newAd = new Ad(
/*            adDTO.getVehicle(),
            adDTO.getComments(),*/
            adDTO.getPickupLocation(),
            adDTO.getPickupFrom(),
            adDTO.getPickupTo()
        );
        return new AdDTO(adRepository.save(newAd));
    }

    @Override
    public List<AdDTO> findAll() {
        return convertToDTO(adRepository.findAll());
    }

    @Override
    public List<AdDTO> findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(
            String pickupLocation, LocalDateTime pickupFrom, LocalDateTime pickupTo) {
        return convertToDTO(adRepository.findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(pickupLocation, pickupFrom, pickupTo));
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
