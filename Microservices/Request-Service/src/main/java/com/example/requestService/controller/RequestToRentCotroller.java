package com.example.requestService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.requestService.dto.RequestToRentDTO;
import com.example.requestService.enumeration.RequestStatusType;
import com.example.requestService.model.RequestToRent;
import com.example.requestService.service.RequestToRentService;
import com.example.requestService.client.AuthenticationClient;
import com.example.requestService.client.VehicleClient;


@RestController
@RequestMapping(value = "/api/request/")
@CrossOrigin(origins = { "http://localhost:4200" })
public class RequestToRentCotroller {

	@Autowired
	private RequestToRentService requestToRentService;

	@Autowired
	private AuthenticationClient authenticationClient;
	@Autowired
	private VehicleClient vehicleClient;

	@PostMapping(value = "/createRequest")
	public ResponseEntity<RequestToRentDTO> addRequest(@RequestBody RequestToRentDTO requestToRentDTO){
		if(requestToRentDTO.getClass() == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		System.out.println("VEHICLE IOD: "+requestToRentDTO.getVehicleId());
		//System.out.println("Znaci ulazis ovde jel daaa ?????");
		//NormalUser normalUser = normalUserService.findById(requestToRentDTO.getNormalUser().getId());
		//System.out.println("DTO:"+requestToRentDTO);
		//Vehicle vehicle = vehicleService.findOne(requestToRentDTO.getVehicle().getId());
		RequestToRent r = new RequestToRent();
		r.setId(111L);
		r.setNormalUser(requestToRentDTO.getNormalUserId());
		r.setRentDateFrom(requestToRentDTO.getRentDateFrom());
		r.setRentDateTo(requestToRentDTO.getRentDateTo());
		r.setRequestStatusType(RequestStatusType.PENDING);
		r.setVehicle(requestToRentDTO.getVehicleId());
		//this.authenticationClient.incrementAds(requestToRentDTO.getNormalUserId());
		
		
		requestToRentService.save(r);
		return new ResponseEntity<>(requestToRentDTO, HttpStatus.CREATED);
		
		
		
		
	}
	
	
	
	@GetMapping(value="/requestToShowForUser/{id}")
	public ResponseEntity<List<RequestToRent>>getRequestsForUser(@PathVariable Long id){
		List<Long>vehicles =  vehicleClient.getVehicleOfUser(id);
		System.out.println("VEHICLES: "+vehicles);
		if (vehicles == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<RequestToRent>requests= new ArrayList<>();
		List<RequestToRent>allRequests = requestToRentService.findAll();
		for(RequestToRent r:allRequests){
			for(Long v:vehicles){
				if(r.getVehicleId() == v){
					requests.add(r);
					
				}
			}
		}
		return new ResponseEntity<>(requests,HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/requestForTaking", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RequestToRentDTO> addUsageOfVehicle(@RequestBody RequestToRentDTO requestToRentDTO){
		if(requestToRentDTO.getClass() == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
		//System.out.println("Znaci ulazis ovde jel daaa ?????");
		//NormalUser normalUser = normalUserService.findById(requestToRentDTO.getNormalUser().getId());
		//System.out.println("DTO:"+requestToRentDTO);
	//	Vehicle vehicle = vehicleService.findOne(requestToRentDTO.getVehicle().getId());
		RequestToRent r = new RequestToRent();
		r.setId(111L);
		r.setNormalUser(requestToRentDTO.getNormalUserId());
		r.setRentDateFrom(requestToRentDTO.getRentDateFrom());
		r.setRentDateTo(requestToRentDTO.getRentDateTo());
		r.setRequestStatusType(RequestStatusType.RESERVED);
		r.setVehicle(requestToRentDTO.getVehicleId());
	
		
		
		List<RequestToRent> requests = requestToRentService.findAll();
		for(RequestToRent rtr:requests){
			if(rtr.getRentDateFrom().compareTo(r.getRentDateTo()) < 0 ){
				rtr.setRequestStatusType(RequestStatusType.CANCELED);
				requestToRentService.save(rtr);
			}
			else if (rtr.getRentDateTo().compareTo(r.getRentDateFrom()) > 0 ){
				rtr.setRequestStatusType(RequestStatusType.CANCELED);
				requestToRentService.save(rtr);
			}
			else if (rtr.getRentDateFrom().compareTo(r.getRentDateFrom()) > 0 && rtr.getRentDateTo().compareTo(r.getRentDateTo()) < 0){
				rtr.setRequestStatusType(RequestStatusType.CANCELED);
				requestToRentService.save(rtr);
			}
		}
		requestToRentService.save(r);
		
		return new ResponseEntity<>(requestToRentDTO, HttpStatus.CREATED);
		
		
		
		
	}
}
