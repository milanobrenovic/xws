package com.xws.tim12.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vehicle {
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private Long idOwner;
	@Column
	private String ownerRole;
	
    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private FuelType fuelType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TransmissionType transmissionType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private VehicleType vehicleType;

 // NotEmpty ne moze za Integer i double tip, samo za stringove i kolekcije radi
    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double travelledMileage;

    @Column(nullable = false)
    private Double plannedMileageToTravel;

    @Column(nullable = false)
    private Boolean isMileageUnlimited;

    @Column()
    private Boolean hasCollisionDamageWaiver;

    @Column(nullable = false)
    private Integer numberOfSeats;

    @Column(nullable = false)
    private Integer grade;

    @Column()
    private Boolean available;

    @Column()
    private Double vehicleDiscount;

    @Column(nullable = false)
    private Double insurancePrice;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<VehicleImage> images;

    public Vehicle() {

    }
    
    
    
    
    public Vehicle(Long id, Long idOwner, String ownerRole, String brand, String model, FuelType fuelType,
			TransmissionType transmissionType, VehicleType vehicleType, Double price, Double travelledMileage,
			Double plannedMileageToTravel, Boolean isMileageUnlimited, Boolean hasCollisionDamageWaiver,
			Integer numberOfSeats, Integer grade, Boolean available, Double vehicleDiscount, Double insurancePrice,
			List<VehicleImage> images) {
		super();
		this.id = id;
		this.idOwner = idOwner;
		this.ownerRole = ownerRole;
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
		this.images = images;
	}




	public Vehicle(Long id, Long idOwner, String brand, String model, FuelType fuelType,
			TransmissionType transmissionType, VehicleType vehicleType, Double price, Double travelledMileage,
			Double plannedMileageToTravel, Boolean isMileageUnlimited, Boolean hasCollisionDamageWaiver,
			Integer numberOfSeats, Integer grade, Boolean available, Double vehicleDiscount, Double insurancePrice,
			List<VehicleImage> images) {
		super();
		this.id = id;
		this.idOwner = idOwner;
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
		this.images = images;
	}

	public Vehicle(Long idOwner, String brand, String model, FuelType fuelType, TransmissionType transmissionType,
			VehicleType vehicleType, Double price, Double travelledMileage, Double plannedMileageToTravel,
			Boolean isMileageUnlimited, Boolean hasCollisionDamageWaiver, Integer numberOfSeats, Integer grade,
			Boolean available, Double vehicleDiscount, Double insurancePrice, List<VehicleImage> images) {
		super();
		this.idOwner = idOwner;
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
		this.images = images;
	}

	public Vehicle(
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
             Double insurancePrice,
            List<VehicleImage> images) {
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
        //this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
	public Long getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(Long idOwner) {
		this.idOwner = idOwner;
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

    public Boolean getMileageUnlimited() {
        return isMileageUnlimited;
    }

    public void setMileageUnlimited(Boolean mileageUnlimited) {
        isMileageUnlimited = mileageUnlimited;
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

    public List<VehicleImage> getImages() {
        return images;
    }

    public void setImages(List<VehicleImage> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fuelType=" + fuelType +
                ", transmissionType=" + transmissionType +
                ", vehicleType=" + vehicleType +
                ", price=" + price +
                ", travelledMileage=" + travelledMileage +
                ", plannedMileageToTravel=" + plannedMileageToTravel +
                ", isMileageUnlimited=" + isMileageUnlimited +
                ", hasCollisionDamageWaiver=" + hasCollisionDamageWaiver +
                ", numberOfSeats=" + numberOfSeats +
                ", grade=" + grade +
                ", available=" + available +
                ", vehicleDiscount=" + vehicleDiscount +
                ", insurancePrice=" + insurancePrice +
               // ", images=" + images.toString() +
                '}';
    }




	public Boolean getIsMileageUnlimited() {
		return isMileageUnlimited;
	}




	public void setIsMileageUnlimited(Boolean isMileageUnlimited) {
		this.isMileageUnlimited = isMileageUnlimited;
	}




	public String getOwnerRole() {
		return ownerRole;
	}




	public void setOwnerRole(String ownerRole) {
		this.ownerRole = ownerRole;
	}
    
    

}
