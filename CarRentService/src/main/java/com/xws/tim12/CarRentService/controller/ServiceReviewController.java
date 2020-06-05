package com.xws.tim12.CarRentService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.CarRentService.service.ServiceReviewService;

@RestController
@RequestMapping(value = "/api/review", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceReviewController {
	
	@Autowired 
	private ServiceReviewService serviceReviewService;
	
	
}
