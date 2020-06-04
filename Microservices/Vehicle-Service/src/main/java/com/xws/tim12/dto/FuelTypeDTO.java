package com.xws.tim12.dto;

import com.xws.tim12.model.FuelType;

public class FuelTypeDTO {

	private Long id;
	
	private String type;

	public FuelTypeDTO() {}
	
	public FuelTypeDTO(String type, Long id) {
		super();
		this.type = type;
		this.id = id;
	}

	public FuelTypeDTO(FuelType fuelType) {
		this.type = fuelType.getType();
		this.id = fuelType.getId();
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
