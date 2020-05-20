package com.xws.tim12.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.xws.tim12.enumeration.FuelType;
import com.xws.tim12.enumeration.TransmissionType;
import com.xws.tim12.enumeration.VehicleType;
import com.xws.tim12.model.VehicleImagePaths;

public class VehicleDTO {
	

    private Long id;


    private String brand;


    private String model;


    private FuelType fuelType;


    private TransmissionType transmissionType;


    private VehicleType vehicleType;


    private Double price;


    private Double travelledMileage;


    private Double plannedMileageToTravel;


    private Boolean isMileageUnlimited;


    private Boolean hasCollisionDamageWaiver;


    private Integer numberOfSeats;


    private Integer grade;

    private Boolean available;


    private Double vehicleDiscount;


    private Double insurancePrice;
    
    
    public VehicleDTO() {
    	
	}
    
    
	public VehicleDTO(Long id, 
			String brand,
			String model,
			FuelType fuelType,
			TransmissionType transmissionType,
			VehicleType vehicleType,
			Double price,
			Double travelledMileage,
			Double plannedMileageToTravel,
			Boolean isMileageUnlimited,
			Boolean hasCollisionDamageWaiver,
			Integer numberOfSeats,
			Integer grade, 
			Boolean available,
			Double vehicleDiscount,
			Double insurancePrice) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.fuelType = fuelType;
		this.transmissionType = transmissionType;
		this.vehicleType = vehicleType;
		this.price = price;
		this.travelledMileage = travelledMileage;
		this.plannedMileageToTravel = plannedMileageToTravel;
		this.isMileageUnlimited = isMileageUnlimited;
		this.hasCollisionDamageWaiver = hasCollisionDamageWaiver;
		this.numberOfSeats = numberOfSeats;
		this.grade = grade;
		this.available = available;
		this.vehicleDiscount = vehicleDiscount;
		this.insurancePrice = insurancePrice;
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

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public TransmissionType getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(TransmissionType transmissionType) {
		this.transmissionType = transmissionType;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTravelledMileage() {
		return travelledMileage;
	}

	public void setTravelledMileage(Double travelledMileage) {
		this.travelledMileage = travelledMileage;
	}

	public Double getPlannedMileageToTravel() {
		return plannedMileageToTravel;
	}

	public void setPlannedMileageToTravel(Double plannedMileageToTravel) {
		this.plannedMileageToTravel = plannedMileageToTravel;
	}

	public Boolean getIsMileageUnlimited() {
		return isMileageUnlimited;
	}

	public void setIsMileageUnlimited(Boolean isMileageUnlimited) {
		this.isMileageUnlimited = isMileageUnlimited;
	}

	public Boolean getHasCollisionDamageWaiver() {
		return hasCollisionDamageWaiver;
	}

	public void setHasCollisionDamageWaiver(Boolean hasCollisionDamageWaiver) {
		this.hasCollisionDamageWaiver = hasCollisionDamageWaiver;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Double getVehicleDiscount() {
		return vehicleDiscount;
	}

	public void setVehicleDiscount(Double vehicleDiscount) {
		this.vehicleDiscount = vehicleDiscount;
	}

	public Double getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(Double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}


	@Override
	public String toString() {
		return "VehicleDTO [id=" + id + ", brand=" + brand + ", model=" + model + ", fuelType=" + fuelType
				+ ", transmissionType=" + transmissionType + ", vehicleType=" + vehicleType + ", price=" + price
				+ ", travelledMileage=" + travelledMileage + ", plannedMileageToTravel=" + plannedMileageToTravel
				+ ", isMileageUnlimited=" + isMileageUnlimited + ", hasCollisionDamageWaiver="
				+ hasCollisionDamageWaiver + ", numberOfSeats=" + numberOfSeats + ", grade=" + grade + ", available="
				+ available + ", vehicleDiscount=" + vehicleDiscount + ", insurancePrice=" + insurancePrice + "]";
	}

    
    
}
