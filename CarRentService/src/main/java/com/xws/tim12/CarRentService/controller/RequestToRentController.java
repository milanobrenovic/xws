package com.xws.tim12.CarRentService.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.CarRentService.dto.CartDTO;
import com.xws.tim12.CarRentService.dto.RequestToRentDTO;
import com.xws.tim12.CarRentService.model.Cart;
import com.xws.tim12.CarRentService.model.RequestToRent;
import com.xws.tim12.CarRentService.model.Vehicle;
import com.xws.tim12.CarRentService.service.RequestToRentService;

@RestController
@RequestMapping(value = "/api/request", produces = MediaType.APPLICATION_JSON_VALUE)
public class RequestToRentController {
	
	@Autowired
	private RequestToRentService requestToRentService;
	

	@PostMapping(value = "/create")
    public ResponseEntity<RequestToRentDTO> create(@RequestBody RequestToRentDTO requestDTO) {
		RequestToRentDTO createdRequest = requestToRentService.createRequest(requestDTO);
        if (createdRequest == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<RequestToRentDTO>(createdRequest, HttpStatus.CREATED);
    }
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<RequestToRent> getRequest(@PathVariable Long id) {
		RequestToRent request = requestToRentService.findById(id);

        if (request == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<RequestToRent>(request, HttpStatus.CREATED);
    }
	
	/*@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, 
			value="/allVehicles/{id}")
	public ResponseEntity<Set<Vehicle>> getAllVehicles(@PathVariable Long id) {
		Set<Vehicle> vehicles = new HashSet<>();
		vehicles = requestToRentService.getAllVehicles(id);
		return (ResponseEntity<List<Ad>>) ads;
		return new ResponseEntity<Set<Vehicle>>(vehicles, HttpStatus.OK);
	}*/
	
	@PostMapping(value = "/add/{id}/to/{id2}")
	public ResponseEntity<RequestToRent> addVehicle(@PathVariable("id") Long id, @PathVariable("id2") Long id2) {
		RequestToRent request = requestToRentService.addVehicleFromCart(id, id2);
		
		return new ResponseEntity<RequestToRent>(request, HttpStatus.OK);
	}
	
	@PostMapping(value = "/addAllFrom/{id}")
	public ResponseEntity<RequestToRent> addVehicles(@PathVariable("id") Long id) {
		RequestToRent request = requestToRentService.addVehiclesFromCart(id);
		
		return new ResponseEntity<RequestToRent>(request, HttpStatus.OK);
	}
	
}
