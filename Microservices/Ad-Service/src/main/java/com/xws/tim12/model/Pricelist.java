package com.xws.tim12.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Pricelist {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Price per day cannot be empty.")
    @Column(nullable = false, scale = 2)
    private Double pricePerDay;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vehicle> listOfVehicles;

    public Pricelist() {

    }

    public Pricelist(
            @NotEmpty(message = "Price per day cannot be empty.") Double pricePerDay,
            List<Vehicle> listOfVehicles) {
        this.pricePerDay = pricePerDay;
        this.listOfVehicles = listOfVehicles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public List<Vehicle> getListOfVehicles() {
        return listOfVehicles;
    }

    public void setListOfVehicles(List<Vehicle> listOfVehicles) {
        this.listOfVehicles = listOfVehicles;
    }

    @Override
    public String toString() {
        return "Pricelist{" +
                "id=" + id +
                ", pricePerDay=" + pricePerDay +
                ", listOfVehicles=" + listOfVehicles.toString() +
                '}';
    }

}
