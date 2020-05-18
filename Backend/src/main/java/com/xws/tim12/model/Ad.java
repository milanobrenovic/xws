package com.xws.tim12.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Ad {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vehicle vehicle;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    @NotEmpty(message = "Pickup location cannot be empty.")
    @NotNull(message = "Pickup location cannot be null.")
    @Column(nullable = false)
    private String pickupLocation;

    @NotEmpty(message = "Pickup from cannot be empty.")
    @NotNull(message = "Pickup from cannot be null.")
    @JsonFormat(pattern = "hh:mm dd-MM-yyyy")
    @Column(nullable = false)
    private LocalTime pickupFrom;

    @NotEmpty(message = "Pickup to cannot be empty.")
    @NotNull(message = "Pickup to cannot be null.")
    @JsonFormat(pattern = "hh:mm dd-MM-yyyy")
    @Column(nullable = false)
    private LocalTime pickupTo;

    public Ad() {

    }

    public Ad(Vehicle vehicle, List<Comment> comments, @NotEmpty(message = "Pickup location cannot be empty.") @NotNull(message = "Pickup location cannot be null.") String pickupLocation, @NotEmpty(message = "Pickup from cannot be empty.") @NotNull(message = "Pickup from cannot be null.") LocalTime pickupFrom, @NotEmpty(message = "Pickup to cannot be empty.") @NotNull(message = "Pickup to cannot be null.") LocalTime pickupTo) {
        this.vehicle = vehicle;
        this.comments = comments;
        this.pickupLocation = pickupLocation;
        this.pickupFrom = pickupFrom;
        this.pickupTo = pickupTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public LocalTime getPickupFrom() {
        return pickupFrom;
    }

    public void setPickupFrom(LocalTime pickupFrom) {
        this.pickupFrom = pickupFrom;
    }

    public LocalTime getPickupTo() {
        return pickupTo;
    }

    public void setPickupTo(LocalTime pickupTo) {
        this.pickupTo = pickupTo;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", comments=" + comments +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", pickupFrom=" + pickupFrom +
                ", pickupTo=" + pickupTo +
                '}';
    }

}
