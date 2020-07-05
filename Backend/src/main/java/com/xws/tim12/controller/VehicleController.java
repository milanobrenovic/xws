package com.xws.tim12.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.dto.VehicleDTO;
import com.xws.tim12.model.Vehicle;
import com.xws.tim12.model.VehicleImage;
import com.xws.tim12.service.VehicleImageService;
import com.xws.tim12.service.VehicleService;

@RestController
@RequestMapping(value = "/api/vehicle/")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleImageService vehicleImageService;
	
	@GetMapping("/{id}")
	public ResponseEntity<VehicleDTO> getVehicle(@PathVariable Long id){
		Vehicle vehicle = vehicleService.findOne(id);
		if (vehicle == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		VehicleDTO vehicleDTO = new VehicleDTO(vehicle);
		return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/createVehicle", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicleDTO){
		if(vehicleDTO.getClass() == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		Vehicle v = new Vehicle();
		v.setAvailable(true);
		v.setBrand(vehicleDTO.getBrand());
		v.setFuelType(vehicleDTO.getFuelType());
		v.setGrade(vehicleDTO.getGrade());
		v.setHasCollisionDamageWaiver(vehicleDTO.getHasCollisionDamageWaiver());
		v.setId(222L);
		v.setInsurancePrice(vehicleDTO.getInsurancePrice());
		v.setMileageUnlimited(vehicleDTO.getIsMileageUnlimited());
		v.setModel(vehicleDTO.getModel());
		v.setNumberOfSeats(vehicleDTO.getNumberOfSeats());
		v.setPlannedMileageToTravel(vehicleDTO.getPlannedMileageToTravel());
		v.setPrice(vehicleDTO.getPrice());
		v.setTransmissionType(vehicleDTO.getTransmissionType());
		v.setTravelledMileage(vehicleDTO.getTravelledMileage());
		v.setVehicleDiscount(vehicleDTO.getVehicleDiscount());
		v.setVehicleType(vehicleDTO.getVehicleType());
		v.setNumberOfSeats(vehicleDTO.getNumberOfSeats());
		v.setImages(new ArrayList<VehicleImage>());
	
		vehicleService.save(v);
		return new ResponseEntity<>(vehicleDTO, HttpStatus.CREATED);
		
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
	
	
	// Ovaj endpoint sluzi za ubacianje slika u vozilo
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehicleDTO> updateVehicle(@RequestBody VehicleDTO vehicleDTO, @PathVariable Long id){
		Vehicle vehicle = vehicleService.findOne(vehicleDTO.getId());
		
		if(vehicle == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		List<VehicleImage> images = vehicle.getImages();
		VehicleImage image = vehicleImageService.findOne(id);
		images.add(image);
		vehicle.setImages(images);
		
		vehicle = vehicleService.save(vehicle);
		
		return new ResponseEntity<>(new VehicleDTO(vehicle), HttpStatus.OK);
	}
	
	@GetMapping("/mostKM")
	public ResponseEntity<VehicleDTO> getKMRecord(){
		
		List<Vehicle> vehicles = vehicleService.findAll();
		
		if(vehicles == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if(vehicles.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		Vehicle v = vehicles.get(0);
		
		for (Vehicle vehicle : vehicles) {
			if(v.getTravelledMileage() > v.getTravelledMileage())
				v = vehicle;
		}

		VehicleDTO vehicleDTO = new VehicleDTO(v);
		
		return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
	}

	@GetMapping("/best-grade")
	public ResponseEntity<VehicleDTO> getRecordGrade(){
		
		List<Vehicle> vehicles = vehicleService.findAll();
		
		if(vehicles == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if(vehicles.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		Vehicle v = vehicles.get(0);
		
		for (Vehicle vehicle : vehicles) {
			if(v.getGrade() > v.getGrade())
				v = vehicle;
		}

		VehicleDTO vehicleDTO = new VehicleDTO(v);
		
		return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
	}
	
}
