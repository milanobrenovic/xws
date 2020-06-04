package com.xws.tim12.CarRentService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.CarRentService.model.Vehicle;
import com.xws.tim12.CarRentService.service.VehicleService;

@RestController
@RequestMapping(value = "/api/vehicle", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable Long id) {
//		Optional<Vehicle> optionalVehicle = vehicleService.findById(id);
		Vehicle vehicle = vehicleService.findById(id);
//		Vehicle vehicle = optionalVehicle.get();
        if (vehicle == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
    }
	
	
}
