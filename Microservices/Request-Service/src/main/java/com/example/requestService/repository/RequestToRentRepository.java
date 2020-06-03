package com.example.requestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.requestService.model.RequestToRent;


public interface RequestToRentRepository extends JpaRepository<RequestToRent,Long>{
	RequestToRent findOneById(Long id);
	
}
