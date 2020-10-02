package com.xws.tim12.dto;

import com.xws.tim12.enumeration.TransportationVehicleType;
import com.xws.tim12.model.TransportationVehicle;

public class TransportationVehicleDTO {
	private Long id;
	private String brand;
	private String model;
	private TransportationVehicleType type;
	
	
	
	public TransportationVehicleDTO() {
		
	}

	

	public TransportationVehicleDTO(Long id, String brand, String model, TransportationVehicleType type) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.type = type;
	}
	public TransportationVehicleDTO(TransportationVehicle tv) {
		super();
		this.id = tv.getId();
		this.brand = tv.getBrand();
		this.model = tv.getModel();
		this.type = tv.getType();
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public TransportationVehicleType getType() {
		return type;
	}



	public void setType(TransportationVehicleType type) {
		this.type = type;
	}
	
	
	
}
