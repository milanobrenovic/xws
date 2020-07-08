package com.xws.tim12.CarRentService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.CarRentService.dto.ServiceReviewDTO;
import com.xws.tim12.CarRentService.enumeration.RequestStatusType;
import com.xws.tim12.CarRentService.model.RequestToRent;
import com.xws.tim12.CarRentService.model.ServiceReview;
import com.xws.tim12.CarRentService.service.RequestToRentService;
import com.xws.tim12.CarRentService.service.ServiceReviewService;

@RestController
@RequestMapping(value = "/api/review/")
public class ServiceReviewController {
	
	@Autowired
	private ServiceReviewService reviewService;
	
	@Autowired
	private RequestToRentService requestService;
	
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
		
		/*if(!r.getRequestStatusType().equals(RequestStatusType.PAID)) {
			System.out.println("Request jos uvek nije zavrsen");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}*/
		
		review.setRequestToRent(r);
		
		reviewService.save(review);
		
		return new ResponseEntity<>(serviceReviewDTO, HttpStatus.CREATED);
		
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
