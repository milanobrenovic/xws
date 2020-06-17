package com.xws.tim12.controller;

import com.xws.tim12.client.AuthenticationClient;
import com.xws.tim12.dto.AdDTO;
import com.xws.tim12.repository.AdRepository;
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
//@RequestMapping(value = "/api/ad", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdController {
	
    @Autowired
    private AdService adService;
    @Autowired
    private AuthenticationClient authenticationClient;
    @Autowired
    private AdRepository adRepository;
    @PostMapping(value = "/create")
    //@PreAuthorize("hasRole('ROLE_NORMAL_USER')")
    public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO,HttpServletRequest httpRequest) {
    /*	if(!authenticationClient.hasRole("ROLE_USER", request)){
    		System.out.println("Ulazis u unnn");
    		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    	}*/
    	System.out.println("ID: "+Long.parseLong(httpRequest.getHeader("id")));
    	if(!httpRequest.getHeader("role").equals("ROLE_NORMAL_USER") && !httpRequest.getHeader("role").equals("ROLE_ADMIN")){
    		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    	}
//    	System.out.println("Ulazak u kreiranje oglasa");
    //	NormalUser currentLogged = normalUserService.getUserLogin();
    	//NormalUser currentLogged = authenticationClient.getIdd(httpRequest.getHeader("id")));
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
            authenticationClient.incrementAds(Long.parseLong(httpRequest.getHeader("id")));
            return new ResponseEntity<>(newAdDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
