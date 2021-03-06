package com.xws.tim12.controller;

import com.xws.tim12.dto.AdDTO;
import com.xws.tim12.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ad", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdController {

    @Autowired
    private AdService adService;

    @PostMapping(value = "/search")
    public ResponseEntity<List<AdDTO>> searchAd(@RequestBody AdDTO adDTO) {
        System.out.println(adDTO);
        try {
            List<AdDTO> searchedAdDTO = adService.findByPickupLocationAndPickupFromLessThanEqualAndPickupToGreaterThanEqual(
                    adDTO.getPickupLocation(),
                    adDTO.getPickupFrom(),
                    adDTO.getPickupTo()
            );
            if (searchedAdDTO == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(searchedAdDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
