package com.xws.tim12.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

public class VehicleImagePaths {
	
    private Long id;

    @NotEmpty(message = "Vehicle id cannot be empty.")
    private Long vehicleId;

    @NotEmpty(message = "Image path cannot be empty.")
    private String imagePath;

    public VehicleImagePaths() {

	}
    
	public VehicleImagePaths(Long id, @NotEmpty(message = "Vehicle id cannot be empty.") Long vehicleId,
			@NotEmpty(message = "Image path cannot be empty.") String imagePath) {
		super();
		this.id = id;
		this.vehicleId = vehicleId;
		this.imagePath = imagePath;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
    
    
    
}
