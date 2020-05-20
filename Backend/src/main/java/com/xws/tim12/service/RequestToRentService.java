package com.xws.tim12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.model.RequestToRent;
import com.xws.tim12.repository.RequestToRentRepository;


@Service
public class RequestToRentService {
	@Autowired
	private RequestToRentRepository requestToRentRepository;

	public RequestToRent save(RequestToRent requestToRent) {
		return requestToRentRepository.save(requestToRent);
	}
/*	public RequestToRent convertFromDTO(RequestToRentDTO rDTO) {
		RequestToRent r = new RequestToRent(rDTO.getId(), rDTO.getVehicle(), rDTO.getRequestStatusType(), rDTO.getNormalUser(), rDTO.getRentDateFrom(), rDTO.getRentDateTo());
		return r;
	}*/
}
