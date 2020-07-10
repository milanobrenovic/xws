package com.xws.tim12.CarRentService.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.xws.tim12.CarRentService.client.AuthenticationClient;
import com.xws.tim12.CarRentService.client.VehicleClient;
import com.xws.tim12.CarRentService.dto.DateFromToDTO;
import com.xws.tim12.CarRentService.dto.RequestToRentDTO;
import com.xws.tim12.CarRentService.enumeration.RequestStatusType;
import com.xws.tim12.CarRentService.model.Cart;
import com.xws.tim12.CarRentService.model.RequestToRent;
import com.xws.tim12.CarRentService.service.CartService;
import com.xws.tim12.CarRentService.service.RequestToRentService;




@RestController
//@RequestMapping(value = "/api/request/")
@CrossOrigin(origins = { "http://localhost:4200" })
public class RequestToRentCotroller {

	@Autowired
	private RequestToRentService requestToRentService;

	/*@Autowired
	private AuthenticationClient authenticationClient;*/
	@Autowired
	private VehicleClient vehicleClient;
	@Autowired
	private CartService cartService;

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
	
	@GetMapping(value = "/acceptRequest/{id}")
	public ResponseEntity<RequestToRent>acceptRequest(@PathVariable Long id){
		RequestToRent r = requestToRentService.findById(id);
		r.setRequestStatusType(RequestStatusType.RESERVED);
		requestToRentService.save(r);
		return new ResponseEntity<>(r,HttpStatus.OK);
	}
	
	@GetMapping(value = "/declineRequest/{id}")
	public ResponseEntity<RequestToRent>declineRequest(@PathVariable Long id){
		RequestToRent r = requestToRentService.findById(id);
		r.setRequestStatusType(RequestStatusType.CANCELED);
		requestToRentService.save(r);
		return new ResponseEntity<>(r,HttpStatus.OK);
	}
	@GetMapping(value = "/pay/{id}")
	public ResponseEntity<RequestToRent>payRequest(@PathVariable Long id){
		RequestToRent r = requestToRentService.findById(id);
		r.setRequestStatusType(RequestStatusType.PAID);
		requestToRentService.save(r);
		return new ResponseEntity<>(r,HttpStatus.OK);
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
	@PostMapping(value = "/makeRequestFromCart/{idCart}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<RequestToRent> addVehiclesFromCart(@PathVariable ("idCart") Long idCart, @RequestHeader(value = "id") Long idLogged, @RequestBody DateFromToDTO dates) {
//		VehicleUser vehicleUser = vehicleUserRepository.findOneById(id2);
		System.out.println(dates.toString());
		List<RequestToRent>requests = new ArrayList<RequestToRent>();
		Cart cart = cartService.findById(idCart);
		for (Long vehicleId : cart.getVehicles()) {
			System.out.println("VehicleID::: "+vehicleId);
			RequestToRentDTO requestDTO = new RequestToRentDTO((Long)22222L, RequestStatusType.PENDING, idLogged, vehicleId, dates.getRentDateFrom(), dates.getRentDateTo());
			RequestToRent r = new RequestToRent();
			r.setId(111L);
			r.setNormalUser(requestDTO.getNormalUserId());
			r.setRentDateFrom(requestDTO.getRentDateFrom());
			r.setRentDateTo(requestDTO.getRentDateTo());
			r.setRequestStatusType(RequestStatusType.PENDING);
			r.setVehicle(requestDTO.getVehicleId());
			//this.authenticationClient.incrementAds(requestToRentDTO.getNormalUserId());

			System.out.println("r:::: "+r);
			requests.add(r);
			requestToRentService.save(r);
		}
		
		
		
		
		
		return requests;
	
	}
}
