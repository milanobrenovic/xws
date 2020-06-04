package com.xws.tim12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.dto.VehicleTypeDTO;
import com.xws.tim12.model.VehicleType;
import com.xws.tim12.service.VehicleTypeService;

@RestController
public class VehicleTypeController {
	
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@GetMapping("/vehicletype/id")
	public ResponseEntity<VehicleTypeDTO> getVehicleType(@PathVariable Long id){
		VehicleType vehicleType = vehicleTypeService.findOne(id);
		
		if(vehicleType == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		VehicleTypeDTO vehicleTypeDTO = new VehicleTypeDTO(vehicleType);
		
		return new ResponseEntity<>(vehicleTypeDTO, HttpStatus.OK);
	}
	
	@GetMapping("vehicletype/all")
	public ResponseEntity<List<VehicleTypeDTO>> getAllVehicleTypes(){
		
		List<VehicleType> vehicleTypes = new ArrayList<>();
		
		vehicleTypes = vehicleTypeService.findAll();
		
		if(vehicleTypes == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<VehicleTypeDTO> vehicleTypeDTOs = new ArrayList<>();
		
		for (VehicleType vehicleType : vehicleTypes) {
			VehicleTypeDTO vehicleTypeDTO = new VehicleTypeDTO(vehicleType);
			vehicleTypeDTOs.add(vehicleTypeDTO);
		}
		
		return new ResponseEntity<>(vehicleTypeDTOs, HttpStatus.OK);
	}
	
	@PostMapping(path = "/createvehicletype", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehicleTypeDTO> createVehicleType(@RequestBody VehicleTypeDTO vehicleTypeDTO){
		if(vehicleTypeDTO.getClass() == null) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		VehicleType vehicleType = vehicleTypeService.convertFromDTO(vehicleTypeDTO);
		
		vehicleTypeService.save(vehicleType);
		
		return new ResponseEntity<>(vehicleTypeDTO, HttpStatus.CREATED);
		
	}
}
