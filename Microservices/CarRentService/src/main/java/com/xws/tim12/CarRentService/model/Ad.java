package com.xws.tim12.CarRentService.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ad {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vehicle vehicle;
    
    //user koji iznajmljuje vozilo
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private VehicleRenter vehicleRenter;
    
    //user koji koristi vozilo
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private VehicleUser vehicleUser;
    
    /*@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;*/

//    @NotEmpty(message = "Pickup location cannot be empty.")
    @NotNull(message = "Pickup location cannot be null.")
    @Column(nullable = false)
    private String pickupLocation;

//    @NotEmpty(message = "Pickup from cannot be empty.")
    @NotNull(message = "Pickup from cannot be null.")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(nullable = false)
    private LocalDateTime pickupFrom;

//    @NotEmpty(message = "Pickup to cannot be empty.")
    @NotNull(message = "Pickup to cannot be null.")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(nullable = false)
    private LocalDateTime pickupTo;
    
    

    public Ad() {

    }

    public Ad(Vehicle vehicle, VehicleRenter vehicleRenter, /*List<Comment> comments,*/
			@NotNull(message = "Pickup location cannot be null.") String pickupLocation,
			@NotNull(message = "Pickup from cannot be null.") LocalDateTime pickupFrom,
			@NotNull(message = "Pickup to cannot be null.") LocalDateTime pickupTo) {
		super();
		this.vehicle = vehicle;
		this.vehicleRenter = vehicleRenter;
		this.vehicleUser = null;
//		this.comments = comments;
		this.pickupLocation = pickupLocation;
		this.pickupFrom = pickupFrom;
		this.pickupTo = pickupTo;
	}

    public Ad(Vehicle vehicle, VehicleRenter vehicleRenter, VehicleUser vehicleUser, /*List<Comment> comments,*/
			@NotNull(message = "Pickup location cannot be null.") String pickupLocation,
			@NotNull(message = "Pickup from cannot be null.") LocalDateTime pickupFrom,
			@NotNull(message = "Pickup to cannot be null.") LocalDateTime pickupTo) {
		super();
		this.vehicle = vehicle;
		this.vehicleRenter = vehicleRenter;
		this.vehicleUser = vehicleUser;
//		this.comments = comments;
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

    /*public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }*/

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public LocalDateTime getPickupFrom() {
        return pickupFrom;
    }

    public void setPickupFrom(LocalDateTime pickupFrom) {
        this.pickupFrom = pickupFrom;
    }

    public LocalDateTime getPickupTo() {
        return pickupTo;
    }

    public void setPickupTo(LocalDateTime pickupTo) {
        this.pickupTo = pickupTo;
    }
    
    

    public VehicleRenter getVehicleRenter() {
		return vehicleRenter;
	}



	public void setVehicleRenter(VehicleRenter vehicleRenter) {
		this.vehicleRenter = vehicleRenter;
	}



	public VehicleUser getVehicleUser() {
		return vehicleUser;
	}



	public void setVehicleUser(VehicleUser vehicleUser) {
		this.vehicleUser = vehicleUser;
	}



	@Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                /*", comments=" + comments +*/
                ", pickupLocation='" + pickupLocation + '\'' +
                ", pickupFrom=" + pickupFrom +
                ", pickupTo=" + pickupTo +
                '}';
    }

}
