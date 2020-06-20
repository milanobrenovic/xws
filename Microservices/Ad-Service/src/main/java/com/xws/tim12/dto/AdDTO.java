package com.xws.tim12.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xws.tim12.model.Ad;
import com.xws.tim12.model.Comment;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class AdDTO {
	
    private Long id;
    
    @NotEmpty(message = "Vehicle is empty.")
    private Long vehicle;
    
    private List<Comment> comments;

    @NotEmpty(message = "Pickup location cannot be empty.")
    @NotNull(message = "Pickup location cannot be null.")
    @Column(nullable = false)
    private String pickupLocation;

//    @NotEmpty(message = "Pickup from cannot be empty.")
    @NotNull(message = "Pickup from cannot be null.")
    @Column(nullable = false)
    private Date pickupFrom;

//    @NotEmpty(message = "Pickup to cannot be empty.")
    @NotNull(message = "Pickup to cannot be null.")
    @Column(nullable = false)
    private Date pickupTo;

    public AdDTO() {

    }
    
    public AdDTO(Ad ad) {
        this(
                ad.getVehicle(),
                ad.getComments(),
                ad.getPickupLocation(),
                ad.getPickupFrom(),
                ad.getPickupTo()
        );
    }

    public AdDTO(@NotEmpty(message = "Vehicle is empty.") Long vehicle, List<Comment> comments, @NotEmpty(message = "Pickup location cannot be empty.") @NotNull(message = "Pickup location cannot be null.") String pickupLocation, @NotEmpty(message = "Pickup from cannot be empty.") @NotNull(message = "Pickup from cannot be null.") Date pickupFrom, @NotEmpty(message = "Pickup to cannot be empty.") @NotNull(message = "Pickup to cannot be null.") Date pickupTo) {
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

    public Long getVehicle() {
        return vehicle;
    }

    public void setVehicle(Long vehicle) {
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

    public Date getPickupFrom() {
        return pickupFrom;
    }

    public void setPickupFrom(Date pickupFrom) {
        this.pickupFrom = pickupFrom;
    }

    public Date getPickupTo() {
        return pickupTo;
    }

    public void setPickupTo(Date pickupTo) {
        this.pickupTo = pickupTo;
    }

    @Override
    public String toString() {
        return "AdDTO{" +
                "id=" + id +
                ", vehicle=" + vehicle.toString() +
                ", comments=" + comments.toString() +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", pickupFrom=" + pickupFrom +
                ", pickupTo=" + pickupTo +
                '}';
    }

}
