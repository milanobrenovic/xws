package com.xws.tim12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.model.Agency;

public interface AgencyRepository extends JpaRepository<Agency,Long>{

	List<Agency> findAll();
	Agency findOneById(Long id);
	
	
}
