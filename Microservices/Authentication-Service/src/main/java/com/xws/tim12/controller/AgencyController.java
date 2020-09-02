package com.xws.tim12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.client.RequestClient;
import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.model.NormalUser;
import com.xws.tim12.service.AgencyService;
import com.xws.tim12.service.NormalUserService;

@RestController
//@RequestMapping(value = "/api/request/")
@CrossOrigin(origins = { "http://localhost:4200" })
public class AgencyController {
	
	@Autowired 
	private AgencyService agencyService;
	
	@Autowired
    private NormalUserService normalUserService;
	
	@Autowired
	private RequestClient requestClient;
	
	
	 @GetMapping(value = "/allQualifiedUsers")
	    public ResponseEntity<List<NormalUser>> getNormalUsersQualified() {
	        try {
	            List<NormalUser> normalUsers = normalUserService.findAll();
	            List<NormalUser> show = new ArrayList<>();
	            if (normalUsers == null) {
	                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	            }
	            for(NormalUser n :normalUsers) {
	            	if(requestClient.getGradesOfUser(n.getId())/n.getNumberOfAds() >= 4) {
	            		
	            	}
	            	
	            }
	            return new ResponseEntity<>(show, HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	
	@PostMapping(value = "/addToAgency/{idAgencije}")
    public ResponseEntity<NormalUser> addToAgencyUser(@PathVariable Long idAgencije,@RequestBody NormalUserDTO normalUser) {
        try {
            NormalUser user = normalUserService.findOneByUsername(normalUser.getUsername());
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            
            agencyService.findById(idAgencije).getAgents().add(user);
            
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
	
	
}
