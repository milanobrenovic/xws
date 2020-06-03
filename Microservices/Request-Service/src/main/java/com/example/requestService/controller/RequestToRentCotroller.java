package com.example.requestService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.requestService.dto.RequestToRentDTO;
import com.example.requestService.model.NormalUser;
import com.example.requestService.model.RequestToRent;
import com.example.requestService.model.Vehicle;
import com.example.requestService.service.NormalUserService;
import com.example.requestService.service.RequestToRentService;
import com.example.requestService.service.VehicleService;

@RestController
@RequestMapping(value = "/api/request/")
public class RequestToRentCotroller {
	@Autowired
	private RequestToRentService requestToRentService;
	@Autowired
	private NormalUserService normalUserService;
	@Autowired
	private VehicleService vehicleService;
	
	
	@PostMapping(value = "/createRequest", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RequestToRentDTO> addRequest(@RequestBody RequestToRentDTO requestToRentDTO){
		if(requestToRentDTO.getClass() == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
		//System.out.println("Znaci ulazis ovde jel daaa ?????");
		NormalUser normalUser = normalUserService.findById(requestToRentDTO.getNormalUser().getId());
		//System.out.println("DTO:"+requestToRentDTO);
		Vehicle vehicle = vehicleService.findOne(requestToRentDTO.getVehicle().getId());
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
