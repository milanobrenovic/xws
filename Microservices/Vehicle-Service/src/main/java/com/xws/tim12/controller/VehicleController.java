package com.xws.tim12.controller;

import com.xws.tim12.dto.VehicleDTO;
import com.xws.tim12.model.Vehicle;
import com.xws.tim12.model.VehicleImage;
import com.xws.tim12.service.VehicleImageService;
import com.xws.tim12.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:8087", "http://localhost:4200" })
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
	@PostMapping("/all-vehicles-from-cart")
	public ResponseEntity<List<VehicleDTO>> getVehiclesFromCart(@RequestBody List<Long> vehicleIds){
		List<VehicleDTO>dtos = new ArrayList <VehicleDTO>();
		for(Long idV : vehicleIds) {

			Vehicle vehicle = vehicleService.findOne(idV);
			if (vehicle == null) {
				continue;
			}
			VehicleDTO vehicleDTO = new VehicleDTO(vehicle);
			dtos.add(vehicleDTO);
		}
		System.out.println(dtos);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@GetMapping("/ownerId/{id}")
	public ResponseEntity<Long> getOwner(@PathVariable("id") Long id){
		Vehicle vehicle = vehicleService.findOne(id);
		if (vehicle == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(vehicle.getIdOwner(), HttpStatus.OK);

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
	
	@GetMapping("/searchVehicles")
	public ResponseEntity<List<VehicleDTO>> getVehicles(@RequestBody VehicleDTO vehicleDTO){
		List<Vehicle> vehicles = vehicleService.findAll();

		if(vehicles == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<VehicleDTO> vehicleDTOs = new ArrayList<>();
		
		for (Vehicle vehicle: vehicles) {
			boolean addToList = false;
			boolean bioFalse = false;
			if(vehicleDTO.getBrand()!=null && !vehicleDTO.getBrand().equals("")) {
				if(vehicle.getBrand().equals(vehicleDTO.getBrand())) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			
			if(vehicleDTO.getModel()!=null && !vehicleDTO.getModel().equals("")) {
				if(vehicle.getModel().equals(vehicleDTO.getModel())) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			
			if(vehicleDTO.getFuelType()!=null ) {
				if(vehicle.getFuelType().equals(vehicleDTO.getFuelType())) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			
			if(vehicleDTO.getTransmissionType()!=null ) {
				if(vehicle.getTransmissionType().equals(vehicleDTO.getTransmissionType())) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			if(vehicleDTO.getVehicleType()!=null ) {
				if(vehicle.getVehicleType().equals(vehicleDTO.getVehicleType())) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
				
			
			if(vehicleDTO.getPrice()!=null ) {
				if(vehicle.getPrice() <= vehicleDTO.getPrice()) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			
			if(vehicleDTO.getTravelledMileage()!=null ) {
				if(vehicle.getTravelledMileage() <= vehicleDTO.getTravelledMileage()) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			
			if(vehicleDTO.getPlannedMileageToTravel()!=null ) {
				if(vehicle.getPlannedMileageToTravel() <= vehicleDTO.getPlannedMileageToTravel()) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			
			if(vehicleDTO.getIsMileageUnlimited()!=null) {
				if(vehicle.getIsMileageUnlimited()==vehicleDTO.getIsMileageUnlimited()) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			
			if(vehicleDTO.getHasCollisionDamageWaiver()!=null) {
				if(vehicle.getHasCollisionDamageWaiver()==vehicleDTO.getHasCollisionDamageWaiver()) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			
			if(vehicleDTO.getNumberOfSeats()!=null ) {
				if(vehicle.getNumberOfSeats() == vehicleDTO.getNumberOfSeats()) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			
			
			if(vehicleDTO.getGrade()!=null ) {
				if(vehicle.getGrade() >= vehicleDTO.getGrade()) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			
			if(vehicleDTO.getAvailable()!=null ) {
				if(vehicle.getAvailable() ==vehicleDTO.getAvailable()) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			
			if(vehicleDTO.getVehicleDiscount()!=null ) {
				if(vehicle.getVehicleDiscount() >= vehicleDTO.getVehicleDiscount()) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			if(vehicleDTO.getInsurancePrice()!=null ) {
				if(vehicle.getInsurancePrice() >= vehicleDTO.getInsurancePrice()) {
					addToList = true;
				}else {
					addToList = false;
					bioFalse = true;
				}
			}
			
			
			if(bioFalse == false) {	
			VehicleDTO vehicleDTOO = new VehicleDTO(vehicle);
			vehicleDTOs.add(vehicleDTOO);
			}
		}
		System.out.println(vehicleDTOs);
		return new ResponseEntity<>(vehicleDTOs, HttpStatus.OK);
	}
	

	
	@PostMapping(value = "/createVehicle", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO, @RequestHeader(value = "Id") String id, @RequestHeader(value = "Role") String role){
		if(vehicleDTO.getClass() == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Long idd = (Long.parseLong(id));
		vehicleDTO.setIdOwner(idd);
		Vehicle vehicle = vehicleService.convertFromDTO(vehicleDTO);
		vehicle.setOwnerRole(role);
		vehicleService.save(vehicle);
		
		return new ResponseEntity<>(vehicleDTO, HttpStatus.CREATED);
	}
	/*--------------------*/
	@GetMapping(path= "/vehicleOfUser/{id}")
	public List<Long> getVehicleOfUser(@PathVariable("id") Long id){
		List<Vehicle> vehicles = vehicleService.findByIdOwner(id);

		if(vehicles == null){
			return null;
		}
		List<Long> vehicless = new ArrayList<>();

		for (Vehicle vehicle: vehicles) {

				vehicless.add(vehicle.getId());

		}

		return vehicless;
	}
	
	// Ovaj endpoint sluzi za ubacivanje slika u vozilo
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
	
	@GetMapping("/images/{id}")
	public ResponseEntity<List<Long>> getAllImagesOfVehicle(@PathVariable("id") Long id) {
		Vehicle vehicle = vehicleService.findOne(id);
		
		List<VehicleImage> images = vehicle.getImages();
		
		if(images == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<Long> imagesIds = new ArrayList<>();
		for (VehicleImage img : images) {
			imagesIds.add(img.getId());
		}
		
		return new ResponseEntity<>(imagesIds, HttpStatus.OK);
		
	}
	
	
}
