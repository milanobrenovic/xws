package com.xws.tim12.CarRentService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.CarRentService.dto.ServiceReviewDTO;
import com.xws.tim12.CarRentService.model.ServiceReview;
import com.xws.tim12.CarRentService.repository.ServiceReviewRepository;
import com.xws.tim12.CarRentService.service.ServiceReviewService;

@Service
public class ServiceReviewServiceImpl implements ServiceReviewService{
	
	@Autowired
	private ServiceReviewRepository serviceReviewRepository;
	
	@Override
	public ServiceReview findById(Long id) {
		if(serviceReviewRepository.findOneById(id) == null) {
			return null;
		}
		
		return serviceReviewRepository.findOneById(id);
	}

	@Override
	public ServiceReviewDTO createReview(ServiceReviewDTO review) {
		ServiceReview s = new ServiceReview(review);
		
		return new ServiceReviewDTO(serviceReviewRepository.save(s));
	}
	
	@Override
	public List<ServiceReview> getAllReviews() {
		List<ServiceReview> reviews = serviceReviewRepository.findAll();
		
		return reviews;		
	}
	
	@Override
	public ServiceReview save(ServiceReview s) {
		return serviceReviewRepository.save(s);
	}
}
