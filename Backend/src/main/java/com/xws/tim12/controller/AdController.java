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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(name = "/create")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO) {
        Admin admin = adminService.getAdminLogin();
        if (admin == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

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

}
