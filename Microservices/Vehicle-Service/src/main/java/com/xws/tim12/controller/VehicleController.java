package com.xws.tim12.controller;

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
@CrossOrigin(origins = { "http://localhost:4200" })
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/vehicle/{id}")
	public ResponseEntity<?> getVehicle(@PathVariable Long id){
		Vehicle vehicle = vehicleService.findOne(id);
		System.out.println("IDVEHICLE: "+id );
		if(vehicle == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		VehicleDTO vehicleDTO = new VehicleDTO(vehicle);
		
		return new ResponseEntity<>(HttpStatus.OK);
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
