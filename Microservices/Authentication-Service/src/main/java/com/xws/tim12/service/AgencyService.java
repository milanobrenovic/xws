package com.xws.tim12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.model.Agency;
import com.xws.tim12.repository.AgencyRepository;

@Service
public class AgencyService{
	@Autowired
	private AgencyRepository agencyRepository;
	
	
	
	public List<Agency> findAll(){
		return agencyRepository.findAll();
	}
	public Agency findById(Long id) {
		return agencyRepository.findOneById(id);
	
}
}
