package com.example.requestService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.requestService.model.RequestToRent;


public interface RequestToRentRepository extends JpaRepository<RequestToRent,Long>{
	RequestToRent findOneById(Long id);
	List<RequestToRent> findAll();
	
}
