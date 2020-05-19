package com.xws.tim12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.dto.RequestToRentDTO;
import com.xws.tim12.model.NormalUser;
import com.xws.tim12.model.RequestToRent;
import com.xws.tim12.model.Vehicle;
import com.xws.tim12.service.NormalUserService;
import com.xws.tim12.service.RequestToRentService;
import com.xws.tim12.service.VehicleService;

@RestController
@RequestMapping(value = "/api/request/")
public class RequestToRentCotroller {
	//@Autowired
	private RequestToRentService requestToRentService;
	@Autowired
	private NormalUserService normalUserService;
	//@Autowired
	private VehicleService vehicleService;
	
	
	@PostMapping(value = "/createRequest", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<RequestToRentDTO> addRequest(@RequestBody RequestToRentDTO requestToRentDTO){
		if(requestToRentDTO.getClass() == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
		System.out.println("Znaci ulazis ovde jel daaa ?????");
		NormalUser normalUser = normalUserService.findByUsername(requestToRentDTO.getNormalUser().getUsername());
		Vehicle vehicle = vehicleService.findOne(requestToRentDTO.getId());
		RequestToRent r = new RequestToRent();
		r.setId(111L);
		r.setNormalUser(normalUser);
		r.setRentDateFrom(requestToRentDTO.getRentDateFrom());
		r.setRentDateTo(requestToRentDTO.getRentDateTo());
		r.setRequestStatusType(requestToRentDTO.getRequestStatusType());
		r.setVehicle(vehicle);
	
		
		
		requestToRentService.save(r);
		return new ResponseEntity<>(requestToRentDTO, HttpStatus.CREATED);
		
		
		
		
	}
}
