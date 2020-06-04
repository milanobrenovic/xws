package com.xws.tim12.dto;

import com.xws.tim12.model.TransmissionType;

public class TransmissionTypeDTO {

	private Long id;
	
	private String type;
	
	public TransmissionTypeDTO() {}

	public TransmissionTypeDTO(String type, Long id) {
		super();
		this.type = type;
		this.id = id;
	}

	public TransmissionTypeDTO(TransmissionType transmissionType) {
		this.type = transmissionType.getType();
		this.id = transmissionType.getId();
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
