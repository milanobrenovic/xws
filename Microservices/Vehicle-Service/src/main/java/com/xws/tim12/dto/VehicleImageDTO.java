package com.xws.tim12.dto;

import com.xws.tim12.model.VehicleImage;

public class VehicleImageDTO {

	private Long id;
	
	private String imageName;
	
	private String imageType;
	
	private byte[] imageBytes;

	public VehicleImageDTO() {}
	
	public VehicleImageDTO(Long id, String imageName, String imageType, byte[] imageBytes) {
		super();
		this.id = id;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageBytes = imageBytes;
	}
	
	public VehicleImageDTO(VehicleImage vehicleImage) {
		this.id = vehicleImage.getId();
		this.imageName = vehicleImage.getImageName();
		this.imageType = vehicleImage.getImageType();
		this.imageBytes = vehicleImage.getImageBytes();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getImageBytes() {
		return imageBytes;
	}

	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}
	
	
}
