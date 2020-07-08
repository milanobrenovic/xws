package com.xws.tim12.CarRentService.service;

import java.util.List;

import com.xws.tim12.CarRentService.dto.ServiceReviewDTO;
import com.xws.tim12.CarRentService.model.ServiceReview;

public interface ServiceReviewService {
	
	ServiceReview findById(Long id);
	
	ServiceReviewDTO createReview(ServiceReviewDTO review);
	
	List<ServiceReview> getAllReviews();
	
	ServiceReview save(ServiceReview s);
}
