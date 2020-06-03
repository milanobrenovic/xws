package com.xws.tim12.controller;

import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.service.NormalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PutMapping(value = "/block/{username}")
    public ResponseEntity<NormalUserDTO> blockNormalUser(@PathVariable("username") String username) {
        try {
            NormalUserDTO normalUserDTO = normalUserService.blockNormalUser(username);
            if (normalUserDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(normalUserDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/unblock/{username}")
    public ResponseEntity<NormalUserDTO> unblockNormalUser(@PathVariable("username") String username) {
        try {
            NormalUserDTO normalUserDTO = normalUserService.unblockNormalUser(username);
            if (normalUserDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(normalUserDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete/{username}")
    public ResponseEntity<NormalUserDTO> deleteNormalUser(@PathVariable("username") String username) {
        try {
            NormalUserDTO normalUserDTO = normalUserService.deleteNormalUser(username);
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
