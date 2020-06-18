package com.xws.tim12.controller;

import java.util.List;

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

import com.xws.tim12.dto.VehicleDTO;
import com.xws.tim12.model.Vehicle;
import com.xws.tim12.service.VehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/vehicle/{id}")
	public ResponseEntity<VehicleDTO> getVehicle(@PathVariable Long id){
		Vehicle vehicle = vehicleService.findOne(id);
		
		if(vehicle == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
		VehicleDTO vehicleDTO = new VehicleDTO(vehicle);
		
		return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
	}
	@GetMapping("/vehicle/all")
	public ResponseEntity<List<Vehicle>> getVehicleAll(){
		List<Vehicle>vehicles = vehicleService.findAll();
		

	
		
		
		return new ResponseEntity<>(vehicles, HttpStatus.OK);
	}
	
	@PostMapping(path = "/createVehicle")
	public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO){
		if(vehicleDTO.getClass() == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		Vehicle vehicle = vehicleService.convertFromDTO(vehicleDTO);
		
		vehicleService.save(vehicle);
		
		return new ResponseEntity<>(vehicleDTO, HttpStatus.CREATED);
	}
	
	
}
