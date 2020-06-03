package com.xws.tim2.CartService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.xws.tim2.CartService.dto.AdDTO;
import com.xws.tim2.CartService.service.AdService;

@RestController
@RequestMapping(value = "/api/ad", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdController {

    @Autowired
    private AdService adService;

    /*@Autowired
    private AdminService adminService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private NormalUserService normalUserService;*/

    @PostMapping(value = "/create")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO) {
        /*try {
            AdDTO newAdDTO = adService.create(adDTO);
            if (newAdDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(newAdDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        */
        AdDTO newAdDTO = adService.create(adDTO);
        return new ResponseEntity<>(newAdDTO, HttpStatus.OK);
    }

}