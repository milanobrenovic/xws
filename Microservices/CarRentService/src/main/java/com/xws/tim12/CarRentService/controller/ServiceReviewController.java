package com.xws.tim12.CarRentService.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xws.tim12.CarRentService.client.VehicleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.xws.tim12.CarRentService.dto.ServiceReviewDTO;
import com.xws.tim12.CarRentService.enumeration.RequestStatusType;
import com.xws.tim12.CarRentService.model.RequestToRent;
import com.xws.tim12.CarRentService.model.ServiceReview;
import com.xws.tim12.CarRentService.service.RequestToRentService;
import com.xws.tim12.CarRentService.service.ServiceReviewService;

@RestController
@RequestMapping(value = "/api/review")
@CrossOrigin(origins = { "http://localhost:4200" })
public class ServiceReviewController {
	
	@Autowired
	private ServiceReviewService reviewService;
	@Autowired
	private VehicleClient vehicleClient;
	@Autowired
	private RequestToRentService requestService;
	@Autowired
	private RequestToRentService requestToRentService;
	@PostMapping(value = "/createReviewFor/{id}")
	public ResponseEntity<ServiceReviewDTO> addReview(@RequestBody ServiceReviewDTO serviceReviewDTO, @PathVariable Long id) {
		if(serviceReviewDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(serviceReviewDTO.getStars() > 5 || serviceReviewDTO.getStars() < 0) {
			System.out.println("Ocena mora biti od 0 do 5!");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		ServiceReview review = new ServiceReview(serviceReviewDTO);
		
		RequestToRent r = requestService.findById(id);
		if(r == null) {
			System.out.println("request nije nadjen");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(r.getServiceReview() != null) {
			System.out.println("Request vec ima review");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	/*	if(!r.getRequestStatusType().equals(RequestStatusType.PAID)) {
			System.out.println("Request jos uvek nije zavrsen");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}*/
		Date now = new Date();  
		   if((now).compareTo(r.getRentDateTo()) < 0){
			   return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		   }
		 		
	    RequestToRent r2 = requestService.findById(id);
		r2.setServiceReview(review);
		requestService.save(r2);
		review.setRequestToRent(r);
		reviewService.save(review);
		
		return new ResponseEntity<>(serviceReviewDTO, HttpStatus.CREATED);
		
	}

	@GetMapping(value="/servicesForUser/{normalUserId}")
	public ResponseEntity<List<ServiceReview>>getRequestsForUser(@PathVariable Long normalUserId,@RequestHeader(value = "Role") String role){
		List<Long>vehicles =  vehicleClient.getVehicleOfUser(normalUserId,role);
		List<ServiceReview>services= new ArrayList<>();

		System.out.println("VEHICLES: "+vehicles);
		if (vehicles == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<RequestToRent>requests= new ArrayList<>();
		List<RequestToRent>allRequests = requestToRentService.findAll();
		for(RequestToRent r:allRequests){
			for(Long v:vehicles){
				if(r.getVehicleId() == v){
					services.add(r.getServiceReview());


				}
			}
		}
		return new ResponseEntity<>(services,HttpStatus.OK);
	}


	@PostMapping(value = "/allReviews")
	public ResponseEntity<List<ServiceReviewDTO>> getAllReviews() {
		List<ServiceReview> reviews = reviewService.getAllReviews();
		
		if(reviews == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		List<ServiceReviewDTO> reviewsDTO = new ArrayList<>();
		
		for(ServiceReview s : reviews) {
			ServiceReviewDTO r = new ServiceReviewDTO(s);
			reviewsDTO.add(r);
		}
		
		return new ResponseEntity<>(reviewsDTO, HttpStatus.OK);
	}
}
