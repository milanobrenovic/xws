package com.xws.tim12.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Ad {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long vehicle;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

//    @NotEmpty(message = "Pickup location cannot be empty.")
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

    public Ad() {

    }

    public Ad(Long vehicle, List<Comment> comments, @NotEmpty(message = "Pickup location cannot be empty.") @NotNull(message = "Pickup location cannot be null.") String pickupLocation, @NotEmpty(message = "Pickup from cannot be empty.") @NotNull(message = "Pickup from cannot be null.") Date pickupFrom, @NotEmpty(message = "Pickup to cannot be empty.") @NotNull(message = "Pickup to cannot be null.") Date pickupTo) {
        this.vehicle = vehicle;
        this.comments = comments;
        this.pickupLocation = pickupLocation;
        this.pickupFrom = pickupFrom;
        this.pickupTo = pickupTo;
    }
    

    public Ad(Long id, Long vehicle, List<Comment> comments,
			@NotNull(message = "Pickup location cannot be null.") String pickupLocation,
			@NotNull(message = "Pickup from cannot be null.") Date pickupFrom,
			@NotNull(message = "Pickup to cannot be null.") Date pickupTo) {
		super();
		this.id = id;
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
