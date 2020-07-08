package com.xws.tim12.CarRentService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.CarRentService.model.RequestToRent;
import com.xws.tim12.CarRentService.repository.RequestToRentRepository;


@Service
public class RequestToRentService {
	@Autowired
	private RequestToRentRepository requestToRentRepository;
	public RequestToRent findById(Long id){
		return requestToRentRepository.findOneById(id);
	}
	public RequestToRent save(RequestToRent requestToRent) {
		return requestToRentRepository.save(requestToRent);
	}
	public List<RequestToRent> findAll(){
		return requestToRentRepository.findAll();
	}
/*	public RequestToRent convertFromDTO(RequestToRentDTO rDTO) {
		RequestToRent r = new RequestToRent(rDTO.getId(), rDTO.getVehicle(), rDTO.getRequestStatusType(), rDTO.getNormalUser(), rDTO.getRentDateFrom(), rDTO.getRentDateTo());
		return r;
	}*/
}
