package com.xws.tim12.model;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class VehicleImage {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imageName;

    @Column
    private String imageType;
    
    // Anotacija koja kaze da se u bazi cuva veliki entitet u obliku niza bajtova
    @Lob
    @Type(type = "org.hibernate.type.ImageType")
	private byte[] imageBytes;
    
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Vehicle vehicle;
    
    public VehicleImage() {

    }

    public VehicleImage(String imageName, String imageType, byte[] imageBytes) {
		super();
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageBytes = imageBytes;
    }

	public VehicleImage(VehicleImage vehicleImage) {
		this.imageName = vehicleImage.imageName;
        this.imageType = vehicleImage.imageType;
        this.imageBytes = vehicleImage.imageBytes;
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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "VehicleImage [id=" + id + ", imageName=" + imageName + ", imageType=" + imageType + ", imageBytes="
				+ Arrays.toString(imageBytes) + "]";
	}

}
