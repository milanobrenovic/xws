package com.xws.tim12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xws.tim12.model.RequestToRent;


public interface RequestToRentRepository extends JpaRepository<RequestToRent,Long>{
	RequestToRent findOneById(Long id);
	
}
