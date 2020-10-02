package com.xws.tim12.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import com.xws.tim12.dto.AgencyDTO;
import com.xws.tim12.dto.ContractRequestDTO;
import com.xws.tim12.dto.NormalUserDTO;
import com.xws.tim12.enumeration.ContractStatus;
import com.xws.tim12.enumeration.UserRanking;
import com.xws.tim12.model.Agency;
import com.xws.tim12.model.ContractRequest;
import com.xws.tim12.model.NormalUser;
import com.xws.tim12.repository.AgencyRepository;
import com.xws.tim12.repository.ContractRequestRepository;
import com.xws.tim12.repository.NormalUserRepository;
import com.xws.tim12.service.AgencyService;
import com.xws.tim12.service.ContractRequestService;
import com.xws.tim12.service.NormalUserService;

@RestController
//@RequestMapping(value = "/api/request/")
@CrossOrigin(origins = { "http://localhost:4200" })
public class AgencyController {
	
	@Autowired 
	private AgencyService agencyService;
	@Autowired 
	private ContractRequestService contractRequestService;
	@Autowired 
	private ContractRequestRepository contractRequestRepository;
	
	@Autowired
    private NormalUserService normalUserService;
	@Autowired
	private NormalUserRepository normalUserRepository;
	@Autowired
	private RequestClient requestClient;
	
	@GetMapping(value ="/agencyOfLogged")
	public Long getAgencyId(@RequestHeader(value = "Id") String id) {
		System.out.println(id);
		Long idd = (Long.parseLong(id));
        NormalUser agent = normalUserService.findById(idd);
        System.out.println(agent);
        System.out.println(agent.getAgency());
        return normalUserService.findById(idd).getAgency().getId();
    }
	@GetMapping(value ="/agentsOfAgency")
	public List<NormalUserDTO> getAgentsOfAgency(@RequestHeader(value = "Id") String id) {
		System.out.println(id);
		Long idd = (Long.parseLong(id));
		List<NormalUserDTO> users = new ArrayList<NormalUserDTO>();
		for(NormalUser a :normalUserService.findById(idd).getAgency().getAgents()) {
        		NormalUserDTO nd = new NormalUserDTO(a);
        		if( nd.getRank()==UserRanking.AGENT)
        		users.add(nd);
        		
        		
        	
        	
        }
        return users;
    }
	
	@GetMapping(value ="/otherAgencies")
	public List<AgencyDTO> getAOtherAgencies(@RequestHeader(value = "Id") String id) {
		System.out.println(id);
		Long idd = (Long.parseLong(id));
		List<AgencyDTO> agencies = new ArrayList<AgencyDTO>();
		Agency agency1 = agencyService.findById(normalUserService.findById(idd).getAgency().getId());
		for(Agency a :agencyService.findAll()) {
        		if(a.getId()!= agency1.getId()) {
        			agencies.add(new AgencyDTO(a.getId(),a.getAgencyName()));
        		}
        		
        		
        	
        	
        }
        return agencies;
    }
	
	@GetMapping(value ="/agencyRequests")
	public List<ContractRequest> getRequests(@RequestHeader(value = "Id") String id) {
		System.out.println(id);
		Long idd = (Long.parseLong(id));
		List<ContractRequest> requests = contractRequestService.findAllByAgencyId1(normalUserService.findById(idd).getAgency().getId());
		
        return requests;
    }
	@GetMapping(value ="/eliteAgentsOfAgency")
	public List<NormalUserDTO> getElitesOfAgency(@RequestHeader(value = "Id") String id) {
		System.out.println(id);
		Long idd = (Long.parseLong(id));
		List<NormalUserDTO> users = new ArrayList<NormalUserDTO>();
		for(NormalUser a :normalUserService.findById(idd).getAgency().getEliteAgents()) {
        		NormalUserDTO nd = new NormalUserDTO(a);
        		if( nd.getRank()==UserRanking.ELITE)
        		users.add(nd);
        		
        		
        	
        	
        }
        return users;
    }
	
	
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
            		if(n.getRank()==UserRanking.NORMAL) {
            		show.add(n);
            		}
            		
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
	            		if(n.getRank()==UserRanking.NORMAL || n.getRank()==UserRanking.PREMIUM) {
	            		show.add(n);
	            		}
	            		
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
            System.out.println("AGENT:  "+agent);
            if(agent.getRank()==UserRanking.NORMAL || agent.getRank()==UserRanking.PREMIUM) {
            	 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            
            Agency agency =agencyService.findById(idAgencije);
            agencyService.findById(idAgencije).getAgents().add(user);
           /* if(agencyService.findById(idAgencije).getAgents().contains(user)) {
            	return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }*/
            user.setRank(UserRanking.AGENT);
            user.setAgency(agency);
            agencyService.findById(idAgencije).getEliteAgents().remove(user);
            normalUserRepository.save(user);
            System.out.println("ubacujeUAgenciju");
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	@PostMapping(value = "/requestContract/{id2}") //PROMENI REQUESTBODY AKO BUDE TREBALO
    public ResponseEntity<ContractRequest> requestContract(@PathVariable Long id2,@RequestHeader(value = "Id") String id) {
        try {
            
            Long idd = (Long.parseLong(id));
            NormalUser agent = normalUserService.findById(idd);
            if(agent.getRank()!=UserRanking.OWNER) {
            	 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            
            ContractRequest cr = new ContractRequest((Long)22L,agent.getAgency().getId(),id2,ContractStatus.PENDING);
            contractRequestRepository.save(cr);
            return new ResponseEntity<>(cr, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
	@PostMapping(value = "/addPartnership") //PROMENI REQUESTBODY AKO BUDE TREBALO
    public ResponseEntity<NormalUser> addPartnership(@RequestBody ContractRequestDTO contractRequest,@RequestHeader(value = "Id") String id) {
        try {
            
            Long idd = (Long.parseLong(id));
            NormalUser agent = normalUserService.findById(idd);
            if(agent.getRank()!=UserRanking.OWNER) {
            	 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            contractRequestService.findById(contractRequest.getId()).setStatus(ContractStatus.ACCEPTED);
            contractRequestRepository.save( contractRequestService.findById(contractRequest.getId()));
            Agency agency =agencyService.findById(contractRequest.getAgencyId1());
            Agency agency2 =agencyService.findById(contractRequest.getAgencyId2());
         
            agency.getAgencies().add(agency2);
            agency2.getAgencies().add(agency);
            
            
            return new ResponseEntity<>(null, HttpStatus.OK);
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
	
	@PostMapping(value = "/demote/{idAgencije}/{idAgenta}")
    public ResponseEntity<NormalUser> demoteAgent(@PathVariable Long idAgencije,@PathVariable Long idAgenta) {
        try {
            NormalUser user = normalUserService.findById(idAgenta);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            
            agencyService.findById(idAgencije).getEliteAgents().remove(user);
            agencyService.findById(idAgencije).getAgents().add(user);
            user.setRank(UserRanking.AGENT);
            normalUserRepository.save(user);
            System.out.println(agencyService.findById(idAgencije).getEliteAgents());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
	}
	
	@PostMapping(value = "/fire/{idAgencije}/{idAgenta}")
    public ResponseEntity<NormalUser> fireAgent(@PathVariable Long idAgencije,@PathVariable Long idAgenta) {
        try {
            NormalUser user = normalUserService.findById(idAgenta);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            
            agencyService.findById(idAgencije).getAgents().remove(user);
            
            user.setRank(UserRanking.NORMAL);
            user.setAgency(null);
            normalUserRepository.save(user);
          //  System.out.println(agencyService.findById(idAgencije).getEliteAgents());
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
