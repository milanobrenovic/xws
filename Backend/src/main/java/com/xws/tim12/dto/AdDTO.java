package com.xws.tim12.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.xws.tim12.model.Ad;
import com.xws.tim12.model.Comment;
import com.xws.tim12.model.Vehicle;

public class AdDTO {
	
    private Long id;
    
    @NotEmpty(message = "Vehicle is empty.")
    private Vehicle vehicle;
    
    private List<Comment> comments;

    public AdDTO() {

    }
    
    public AdDTO(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.comments = new ArrayList<Comment>();
    }

    public AdDTO(Vehicle vehicle, List<Comment> comments) {
        this.vehicle = vehicle;
        this.comments = comments;
    }
    
    public AdDTO(AdDTO ad) {
        this.vehicle = ad.vehicle;
        this.comments = ad.comments;
    }
    
    public AdDTO(Ad ad) {
        this(ad.getVehicle(), ad.getComments());
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
}
