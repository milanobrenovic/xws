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

import com.xws.tim12.dto.TransmissionTypeDTO;
import com.xws.tim12.model.TransmissionType;
import com.xws.tim12.service.TransmissionTypeService;

@RestController
public class TransimissionTypeController {

	@Autowired
	private TransmissionTypeService transmissionTypeService;
	
	@GetMapping("/transmissiontype/id")
	public ResponseEntity<TransmissionTypeDTO> getTransmissionType(@PathVariable Long id){
		TransmissionType transmissionType = transmissionTypeService.findOne(id);
		
		if(transmissionType == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		TransmissionTypeDTO transmissionTypeDTO = new TransmissionTypeDTO(transmissionType);
		
		return new ResponseEntity<>(transmissionTypeDTO, HttpStatus.OK);
	}
	
	@GetMapping("transmissiontype/all")
	public ResponseEntity<List<TransmissionTypeDTO>> getAllTransmissionTypes(){
		
		List<TransmissionType> transmissionTypes = new ArrayList<>();
		
		transmissionTypes = transmissionTypeService.findAll();
		
		if(transmissionTypes == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<TransmissionTypeDTO> transmissionTypeDTOs = new ArrayList<>();
		
		for (TransmissionType transmissionType : transmissionTypes) {
			TransmissionTypeDTO transmissionTypeDTO = new TransmissionTypeDTO(transmissionType);
			transmissionTypeDTOs.add(transmissionTypeDTO);
		}
		
		return new ResponseEntity<>(transmissionTypeDTOs, HttpStatus.OK);
	}
	
	@PostMapping(path = "/createtransmissiontype", consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<TransmissionTypeDTO> createTransmissionType(@RequestBody TransmissionTypeDTO transmissionTypeDTO){
		if(transmissionTypeDTO.getClass() == null) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		TransmissionType transmissionType = transmissionTypeService.convertFromDTO(transmissionTypeDTO);
		
		transmissionTypeService.save(transmissionType);
		
		return new ResponseEntity<>(transmissionTypeDTO, HttpStatus.CREATED);
		
	}
}
