package com.xws.tim12.controller;

import com.xws.tim12.dto.AdDTO;
import com.xws.tim12.model.Admin;
import com.xws.tim12.service.AdService;
import com.xws.tim12.service.AdminService;
import com.xws.tim12.service.AgentService;
import com.xws.tim12.service.NormalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ad", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdController {

    @Autowired
    private AdService adService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private NormalUserService normalUserService;

    @PostMapping(value = "/create")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO) {
        try {
            AdDTO newAdDTO = adService.create(adDTO);
            if (newAdDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(newAdDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/search")
    public ResponseEntity<List<AdDTO>> searchAd(@RequestBody AdDTO adDTO) {
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
