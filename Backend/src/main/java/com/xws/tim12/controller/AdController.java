package com.xws.tim12.controller;

import com.xws.tim12.dto.AdDTO;
import com.xws.tim12.model.Admin;
import com.xws.tim12.model.NormalUser;
import com.xws.tim12.repository.NormalUserRepository;
import com.xws.tim12.security.TokenUtils;
import com.xws.tim12.service.AdService;
import com.xws.tim12.service.AdminService;
import com.xws.tim12.service.AgentService;
import com.xws.tim12.service.NormalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/ad/")
public class AdController {

	@Autowired
	TokenUtils tokenUtils;
    @Autowired
    private AdService adService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private NormalUserService normalUserService;
    @Autowired
    private NormalUserRepository normalUserRepository;

    @PostMapping(value = "/create")
    //@PreAuthorize("hasRole('ROLE_NORMAL_USER')")
    public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO,HttpServletRequest request) {
//    	System.out.println("Ulazak u kreiranje oglasa");
    //	NormalUser currentLogged = normalUserService.getUserLogin();
    	String token = tokenUtils.getToken(request);
    	String user = tokenUtils.getUsernameFromToken(token);
    	//System.out.println("user??"+user);
    	NormalUser normalUser = normalUserService.findOneByUsername(user);

        if(normalUser == null){
    		 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    	}
    	if(normalUser.getNumberOfAds() != null && normalUser.getNumberOfAds() > 2){
    		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    	}
    	System.out.println("User :"+ normalUser.getUsername());
    	try {
            AdDTO newAdDTO = adService.create(adDTO);
            if (newAdDTO == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            normalUser.setNumberOfAds(normalUser.getNumberOfAds() + 1);
            normalUserRepository.save(normalUser);
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
