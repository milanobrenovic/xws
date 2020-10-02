package com.xws.tim12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.dto.ContractRequestDTO;
import com.xws.tim12.model.Agency;
import com.xws.tim12.model.ContractRequest;

public interface ContractRequestRepository extends JpaRepository<ContractRequest,Long>{

	List<ContractRequest> findAll();
	ContractRequest findOneById(Long id);
	List<ContractRequest> findAllByAgencyId1(Long agencyId1);
	
}
