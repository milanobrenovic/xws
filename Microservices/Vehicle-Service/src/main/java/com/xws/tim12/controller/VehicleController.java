package com.xws.tim12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.xws.tim12.dto.VehicleDTO;
import com.xws.tim12.model.Vehicle;
import com.xws.tim12.service.VehicleService;

@RestController
@CrossOrigin(origins = { "http://localhost:8087", "http://localhost:4200" })
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/{id}")
	public ResponseEntity<VehicleDTO> getVehicle(@PathVariable Long id){
		Vehicle vehicle = vehicleService.findOne(id);
		if (vehicle == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		VehicleDTO vehicleDTO = new VehicleDTO(vehicle);
		return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<VehicleDTO>> getVehicleAll(){
		List<Vehicle> vehicles = vehicleService.findAll();

		if(vehicles == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<VehicleDTO> vehicleDTOs = new ArrayList<>();

		for (Vehicle vehicle: vehicles) {
			VehicleDTO vehicleDTO = new VehicleDTO(vehicle);
			vehicleDTOs.add(vehicleDTO);
		}

		return new ResponseEntity<>(vehicleDTOs, HttpStatus.OK);
	}
	
	@PostMapping(path = "/createVehicle")
	public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO, @RequestHeader(value = "Id") String id){
		if(vehicleDTO.getClass() == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Long idd = (Long.parseLong(id));
		vehicleDTO.setIdOwner(idd);
		Vehicle vehicle = vehicleService.convertFromDTO(vehicleDTO);
		
		vehicleService.save(vehicle);
		
		return new ResponseEntity<>(vehicleDTO, HttpStatus.CREATED);
	}
	@GetMapping(path= "/vehicleOfUser/{id}")
	public ResponseEntity<List<VehicleDTO>> getVehicleOfUser(@PathVariable Long id){
		List<Vehicle> vehicles = vehicleService.findByIdOwner(id);

		if(vehicles == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<VehicleDTO> vehicleDTOs = new ArrayList<>();

		for (Vehicle vehicle: vehicles) {
			VehicleDTO vehicleDTO = new VehicleDTO(vehicle);
			vehicleDTOs.add(vehicleDTO);
		}

		return new ResponseEntity<>(vehicleDTOs, HttpStatus.OK);
	}
	
	
}
