package com.example.requestService.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import com.example.requestService.enumeration.FuelType;
import com.example.requestService.enumeration.TransmissionType;
import com.example.requestService.enumeration.VehicleType;

import java.util.List;

@Entity
public class Vehicle {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @NotEmpty(message = "Brand cannot be empty.")
    @Column(nullable = false)
    private String brand;

   // @NotEmpty(message = "Model cannot be empty.")
    @Column(nullable = false)
    private String model;

   // @NotEmpty(message = "Fuel type cannot be empty.")
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

   // @NotEmpty(message = "Transmission type cannot be empty.")
    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;

   // @NotEmpty(message = "Vehicle type cannot be empty.")
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

   // @NotEmpty(message = "Price cannot be empty.")
    @Column(nullable = false)
    private Double price;

   // @NotEmpty(message = "Travelled mileage cannot be empty.")
    @Column(nullable = false)
    private Double travelledMileage;

   // @NotEmpty(message = "Planned mileage to travel cannot be empty.")
   @Column(nullable = false)
    private Double plannedMileageToTravel;

  //  @NotEmpty(message = "Unlimited mileage cannot be empty.")
//    @Column(nullable = false)
    @Column()
    private Boolean isMileageUnlimited;

    @Column()
    private Boolean hasCollisionDamageWaiver;

   // @NotEmpty(message = "Number of seats cannot be empty.")
    @Column(nullable = false)
    private Integer numberOfSeats;

   // @NotEmpty(message = "Grade cannot be empty.")
    @Column(nullable = false)
    private Integer grade;

    @Column()
    private Boolean available;

    @Column()
    private Double vehicleDiscount;

   // @NotEmpty(message = "Insurance price cannot be empty.")
    @Column(nullable = false)
    private Double insurancePrice;



    public Vehicle() {

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
            Double insurancePrice) {
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
             //   ", images=" + images.toString() +
                '}';
    }

}
