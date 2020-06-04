package com.xws.tim12.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.model.TransmissionType;

public interface TransmissionTypeRepository extends JpaRepository<TransmissionType, Long>{

	TransmissionType findOneById(Long id);
	
	TransmissionType findByType(String type);
}
