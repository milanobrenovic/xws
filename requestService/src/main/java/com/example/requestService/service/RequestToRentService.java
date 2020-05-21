package com.example.requestService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.requestService.model.RequestToRent;
import com.example.requestService.repository.RequestToRentRepository;


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
