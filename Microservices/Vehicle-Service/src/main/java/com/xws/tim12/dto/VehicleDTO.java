package com.xws.tim12.dto;

import com.xws.tim12.model.Vehicle;

public class VehicleDTO {

    private String brand;

    private String model;

    private Long fuelType;

    private Long transmissionType;

    private Long vehicleType;

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
    
    
	public VehicleDTO(Long id,  String brand,
			 String model,
			 Double price,
			 Long fuelType,
			 Long transmissionType,
			 Long vehicleType,
			 Double travelledMileage,
			 Double plannedMileageToTravel,
			 Boolean isMileageUnlimited,
			Boolean hasCollisionDamageWaiver,
			 Integer numberOfSeats,
			 Integer grade, Boolean available,
			 Double vehicleDiscount,
			 Double insurancePrice) {
		super();
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
	
	public VehicleDTO(Vehicle vehicle) {
		super();
		this.brand = vehicle.getBrand();
		this.model = vehicle.getModel();
		this.fuelType = vehicle.getFuelType().getId();
		this.transmissionType = vehicle.getTransmissionType().getId();
		this.vehicleType = vehicle.getVehicleType().getId();
		this.price = vehicle.getPrice();
		this.travelledMileage = vehicle.getTravelledMileage();
		this.plannedMileageToTravel = vehicle.getPlannedMileageToTravel();
		this.isMileageUnlimited = vehicle.getMileageUnlimited();
		this.hasCollisionDamageWaiver = vehicle.getHasCollisionDamageWaiver();
		this.numberOfSeats = vehicle.getNumberOfSeats();
		this.grade = vehicle.getGrade();
		this.available = vehicle.getAvailable();
		this.vehicleDiscount = vehicle.getVehicleDiscount();
		this.insurancePrice = vehicle.getInsurancePrice();
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

	public Long getFuelType() {
		return fuelType;
	}

	public void setFuelType(Long fuelType) {
		this.fuelType = fuelType;
	}

	public Long getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(Long transmissionType) {
		this.transmissionType = transmissionType;
	}

	public Long getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(Long vehicleType) {
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

}
