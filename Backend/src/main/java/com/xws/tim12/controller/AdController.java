package com.xws.tim12.controller;

import java.time.format.DateTimeParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.dto.AdDTO;
import com.xws.tim12.model.Ad;
import com.xws.tim12.service.AdService;


@RestController
@RequestMapping(value = "/api/auth/ad")
public class AdController {
	
	@Autowired
	private AdService adService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ad> create(@RequestBody AdDTO ad) {
        try {
            Ad createdAd = adService.create(ad);
            if (createdAd == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Ad>(createdAd, HttpStatus.CREATED);
        } catch (DateTimeParseException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
}
