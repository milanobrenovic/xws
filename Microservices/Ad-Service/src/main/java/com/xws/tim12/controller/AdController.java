package com.xws.tim12.controller;

import com.xws.tim12.client.AuthenticationClient;
import com.xws.tim12.dto.AdDTO;

import com.xws.tim12.service.AdService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    private AuthenticationClient authenticationClient;
    @PostMapping(value = "/create")
    //@PreAuthorize("hasRole('ROLE_NORMAL_USER')")
    public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO,HttpServletRequest request) {
//    	System.out.println("Ulazak u kreiranje oglasa");
    //	NormalUser currentLogged = normalUserService.getUserLogin();
    //	String token = tokenUtils.getToken(request);
    //	String user = tokenUtils.getUsernameFromToken(token);
    	//System.out.println("user??"+user);
    //	NormalUser normalUser = normalUserService.findOneByUsername(user);

     /*   if(normalUser == null){
    		 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    	}
    	if(normalUser.getNumberOfAds() != null && normalUser.getNumberOfAds() > 2){
    		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    	}
    	System.out.println("User :"+ normalUser.getUsername());*/
    	try {
            AdDTO newAdDTO = adService.create(adDTO);
            if (newAdDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        //    normalUser.setNumberOfAds(normalUser.getNumberOfAds() + 1);
        //    normalUserRepository.save(normalUser);
            authenticationClient.incrementAds("eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJYd3MiLCJzdWIiOiJ1c2VyMSIsImF1ZCI6IndlYiIsImlhdCI6MTU5MTM5MjI1NywiZXhwIjoxNTkxNDc4NjU3fQ.rG-2GXEG05Pbe-ZkpjrnxxXPT8jF5vfGevaM7u4yp-lTP2HVH_CJfXtAV_w9kr8FVfoWGt1-Lg645Nw2hQhidw",1L);
            return new ResponseEntity<>(newAdDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
