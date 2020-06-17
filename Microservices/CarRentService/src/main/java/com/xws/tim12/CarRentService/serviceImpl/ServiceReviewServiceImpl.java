package com.xws.tim12.CarRentService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
}
