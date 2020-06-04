package com.xws.tim12.CarRentService.dto;

import com.xws.tim12.CarRentService.enumeration.RequestStatusType;

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
