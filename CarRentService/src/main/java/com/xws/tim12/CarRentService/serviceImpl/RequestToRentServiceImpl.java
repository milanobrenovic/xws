package com.xws.tim12.CarRentService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.CarRentService.model.RequestToRent;
import com.xws.tim12.CarRentService.repository.RequestToRentRepository;
import com.xws.tim12.CarRentService.service.RequestToRentService;

@Service
public class RequestToRentServiceImpl implements RequestToRentService {
	
	@Autowired 
	private RequestToRentRepository requestToRentRepository;

	@Override
	public RequestToRent findById(Long id) {
		if(requestToRentRepository.findOneById(id) == null) {
			return null;
		}
		
		return requestToRentRepository.findOneById(id);
	}
	
	
}
