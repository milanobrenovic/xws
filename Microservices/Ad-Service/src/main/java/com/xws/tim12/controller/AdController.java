package com.xws.tim12.controller;

import com.xws.tim12.client.AuthenticationClient;
import com.xws.tim12.client.VehicleClient;
import com.xws.tim12.dto.AdDTO;
import com.xws.tim12.repository.AdRepository;
import com.xws.tim12.service.AdService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping(value = "/api/ad", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = { "http://localhost:4200" })
public class AdController {
	
    @Autowired
    private AdService adService;
    @Autowired
    private AuthenticationClient authenticationClient;
    @Autowired
    private VehicleClient vehicleClient;
    @Autowired
    private AdRepository adRepository;


    @PostMapping(value = "/create")
    public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO, @RequestHeader(value = "Role") String role, @RequestHeader(value = "Id") String id) {
        if (!role.equals("ROLE_NORMAL_USER")){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    	if(vehicleClient.getVehicle(adDTO.getVehicle())==null){
    		return new ResponseEntity<>(HttpStatus.CONFLICT);
    	}
    	Long idd = (Long.parseLong(id));
    	if(authenticationClient.getNumberOfAds(idd) >= 3){
    		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    	}
    		
    	try {
            AdDTO newAdDTO = adService.create(adDTO);
            
            if (newAdDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            else{
            	authenticationClient.incrementAds(Long.parseLong(/*httpRequest.getHeader("id")*/id));
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
    @GetMapping(value = "/getAds")
    public ResponseEntity<List<AdDTO>> getAds(){
    	List<AdDTO> ads = adService.findAll();
    	if(ads == null){
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<>(ads,HttpStatus.OK);
    	
    	
    }

}
