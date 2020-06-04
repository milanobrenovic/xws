package com.xws.tim12.dto;

import com.xws.tim12.model.VehicleType;

public class VehicleTypeDTO {

	private Long id;
	
	private String type;
	
	public VehicleTypeDTO() {}

	public VehicleTypeDTO(String type, Long id) {
		super();
		this.type = type;
		this.id = id;
	}

	public VehicleTypeDTO(VehicleType vehicleType) {
		this.type = vehicleType.getType();
		this.id = vehicleType.getId();
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
