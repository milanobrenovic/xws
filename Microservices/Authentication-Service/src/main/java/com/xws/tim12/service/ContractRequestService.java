package com.xws.tim12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.dto.ContractRequestDTO;
import com.xws.tim12.model.ContractRequest;
import com.xws.tim12.repository.ContractRequestRepository;

@Service
public class ContractRequestService {
	@Autowired
	private ContractRequestRepository contractRequestRepository;
	
	public List<ContractRequest> findAll(){
		return contractRequestRepository.findAll();
		
	}
	public ContractRequest findById(Long id) {
		return contractRequestRepository.findOneById(id);
	}
	public List<ContractRequest> findAllByAgencyId1(Long agencyId1){
		return contractRequestRepository.findAllByAgencyId1(agencyId1);
	}
	
}
