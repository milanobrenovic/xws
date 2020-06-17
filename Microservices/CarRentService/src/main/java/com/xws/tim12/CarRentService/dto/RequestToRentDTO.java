package com.xws.tim12.CarRentService.dto;

import com.xws.tim12.CarRentService.enumeration.RequestStatusType;
import com.xws.tim12.CarRentService.model.RequestToRent;

public class RequestToRentDTO {
	
	private Long id;
	
	private RequestStatusType status;

	
	public RequestToRentDTO() {
		super();
	}
	
	public RequestToRentDTO(Long id, RequestStatusType status) {
		super();
		this.id = id;
		this.status = status;
	}
	
	public RequestToRentDTO(RequestToRent request) {
		super();
		this.id = request.getId();
		this.status = request.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RequestStatusType getStatus() {
		return status;
	}

	public void setStatus(RequestStatusType status) {
		this.status = status;
	}
	
	
	
	
}
