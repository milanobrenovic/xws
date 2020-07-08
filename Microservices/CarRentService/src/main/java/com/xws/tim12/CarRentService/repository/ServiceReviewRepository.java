package com.xws.tim12.CarRentService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.CarRentService.model.ServiceReview;

public interface ServiceReviewRepository extends JpaRepository<ServiceReview, Long>{
	
	ServiceReview findOneById(Long id);
	
	List<ServiceReview> findAll();
}
