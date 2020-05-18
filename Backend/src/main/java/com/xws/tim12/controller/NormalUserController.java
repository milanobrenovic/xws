package com.xws.tim12.controller;

import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.service.NormalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth/user")
public class NormalUserController {

    @Autowired
    private NormalUserService normalUserService;

    @PostMapping(value = "/register")
    public ResponseEntity<NormalUserDTO> register(@RequestBody NormalUserDTO normalUser) {
        try {
            NormalUserDTO normalUserDTO = normalUserService.createNormalUser(normalUser);
            if (normalUserDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(normalUserDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
