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

import javax.servlet.http.HttpServletRequest;
import com.xws.tim12.dto.FuelTypeDTO;
import com.xws.tim12.model.FuelType;
import com.xws.tim12.service.FuelTypeService;

@RestController
public class FuelTypeController {

	@Autowired
	private FuelTypeService fuelTypeService;
	
	@GetMapping("/fueltype/id")
	public ResponseEntity<FuelTypeDTO> getFuelType(@PathVariable Long id){
		FuelType fuelType = fuelTypeService.findOne(id);
		
		if(fuelType == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		FuelTypeDTO fuelTypeDTO = new FuelTypeDTO(fuelType);
		
		return new ResponseEntity<>(fuelTypeDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("fueltype/all")
	public ResponseEntity<List<FuelTypeDTO>> getAllFuelTypes(HttpServletRequest httpRequest){
		
		String role = httpRequest.getHeader("role");

		if(!role.equals("ROLE_ADMIN")){
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		List<FuelType> fuelTypes = new ArrayList<>();
		
		fuelTypes = fuelTypeService.findAll();
		
		if(fuelTypes == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<FuelTypeDTO> fuelTypeDTOs = new ArrayList<>();
		
		for (FuelType fuelType : fuelTypes) {
			FuelTypeDTO fuelTypeDTO = new FuelTypeDTO(fuelType);
			fuelTypeDTOs.add(fuelTypeDTO);
		}
		
		return new ResponseEntity<>(fuelTypeDTOs, HttpStatus.OK);
	}
	
	@PostMapping(path = "/createfueltype", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FuelTypeDTO> createFuelType(@RequestBody FuelTypeDTO fuelTypeDTO, HttpServletRequest httpRequest){
		
		String role = httpRequest.getHeader("role");

		if(!role.equals("ROLE_ADMIN")){
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		if(fuelTypeDTO.getClass() == null) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		FuelType fuelType = fuelTypeService.convertFromDTO(fuelTypeDTO);
		
		fuelTypeService.save(fuelType);
		
		return new ResponseEntity<>(fuelTypeDTO, HttpStatus.CREATED);
		
	}
}
