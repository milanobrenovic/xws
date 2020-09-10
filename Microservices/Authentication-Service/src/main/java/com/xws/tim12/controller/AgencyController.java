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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.client.RequestClient;
import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.enumeration.UserRanking;
import com.xws.tim12.model.Agency;
import com.xws.tim12.model.NormalUser;
import com.xws.tim12.repository.NormalUserRepository;
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
	private NormalUserRepository normalUserRepository;
	@Autowired
	private RequestClient requestClient;
	
	@GetMapping(value = "/allQualifiedUsersForPremium")
    public ResponseEntity<List<NormalUser>> getPremiumQualified() {
        try {
            List<NormalUser> normalUsers = normalUserService.findAll();
            List<NormalUser> show = new ArrayList<>();
            if (normalUsers == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            for(NormalUser n :normalUsers) {
            	System.out.println("user sa id:  " +n.getId());
            	Double sum = requestClient.getGradesOfUser(n.getId());
            	System.out.println("SUM:  "+sum);
            	if(sum >=4 && n.getNumberOfAds() >= 2) {
            		show.add(n);
            		
            	}
            	
            }
            return new ResponseEntity<>(show, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
	
	
	 @GetMapping(value = "/allQualifiedUsers")
	    public ResponseEntity<List<NormalUser>> getNormalUsersQualified() {
	        try {
	            List<NormalUser> normalUsers = normalUserService.findAll();
	            List<NormalUser> show = new ArrayList<>();
	            if (normalUsers == null) {
	                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	            }
	            for(NormalUser n :normalUsers) {
	            	System.out.println("user sa id:  " +n.getId());
	            	Double sum = requestClient.getGradesOfUser(n.getId());
	            	System.out.println("SUM:  "+sum);
	            	if(sum >=4 ) {
	            		show.add(n);
	            		
	            	}
	            	
	            }
	            return new ResponseEntity<>(show, HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	
	@PostMapping(value = "/addToAgency/{idAgencije}/{idUsera}") //PROMENI REQUESTBODY AKO BUDE TREBALO
    public ResponseEntity<NormalUser> addToAgencyUser(@PathVariable Long idAgencije,@PathVariable Long idUsera,@RequestHeader(value = "Id") String id) {
        try {
            NormalUser user = normalUserService.findById(idUsera);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Long idd = (Long.parseLong(id));
            NormalUser agent = normalUserService.findById(idd);
            if(agent.getRank()!=UserRanking.AGENT) {
            	 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            
            Agency agency =agencyService.findById(idAgencije);
            agencyService.findById(idAgencije).getAgents().add(user);
            user.setRank(UserRanking.AGENT);
            user.setAgency(agency);
            normalUserRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
	@PostMapping(value = "/addPartnerShipy/{idAgencije}/") //PROMENI REQUESTBODY AKO BUDE TREBALO
    public ResponseEntity<NormalUser> addPartnership(@PathVariable Long idAgencije,@RequestHeader(value = "Id") String id) {
        try {
            
            Long idd = (Long.parseLong(id));
            NormalUser agent = normalUserService.findById(idd);
            if(agent.getRank()!=UserRanking.OWNER) {
            	 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            
            Agency agency =agencyService.findById(idAgencije);
            agency.getAgencies().add(agencyService.findById(idAgencije));
            
            return new ResponseEntity<>(agent, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
	
	
	@PostMapping(value = "/promote/{idAgencije}/{idAgenta}")
    public ResponseEntity<NormalUser> promoteAgent(@PathVariable Long idAgencije,@PathVariable Long idAgenta) {
        try {
            NormalUser user = normalUserService.findById(idAgenta);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            
            agencyService.findById(idAgencije).getAgents().remove(user);
            agencyService.findById(idAgencije).getEliteAgents().add(user);
            user.setRank(UserRanking.ELITE);
            normalUserRepository.save(user);
            System.out.println(agencyService.findById(idAgencije).getEliteAgents());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
	@PostMapping(value = "/promoteToLeader/{idAgencije}/{idAgenta}")
    public ResponseEntity<NormalUser> promoteAgentToLeader(@PathVariable Long idAgencije,@PathVariable Long idAgenta,@RequestHeader(value = "Id") String id) {
        try {
            NormalUser user = normalUserService.findById(idAgenta);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Long idd = (Long.parseLong(id));
            NormalUser leader = normalUserService.findById(idd);
            if(leader.getRank()!=UserRanking.OWNER) {
            	 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            agencyService.findById(idAgencije).getEliteAgents().remove(user);
            agencyService.findById(idAgencije).setAgencyLeader(user);
            agencyService.findById(idAgencije).getEliteAgents().add(leader);
           // agencyService.findById(idAgencije).getEliteAgents().add(user);
            user.setRank(UserRanking.OWNER);
            leader.setRank(UserRanking.ELITE);
            normalUserRepository.save(user);
            normalUserRepository.save(leader);
            System.out.println(agencyService.findById(idAgencije).getEliteAgents());
            System.out.println("Agency leader: +++++" +agencyService.findById(idAgencije).getAgencyLeader());

            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
}
