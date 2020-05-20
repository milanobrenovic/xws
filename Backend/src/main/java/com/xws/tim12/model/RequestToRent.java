package com.xws.tim12.model;

import com.xws.tim12.enumeration.RequestStatusType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class RequestToRent {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Vehicle vehicle;

    @Enumerated(EnumType.STRING)
    private RequestStatusType requestStatusType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private NormalUser normalUser;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Agent agent;

   // @NotEmpty(message = "Rent date from cannot be empty.")
    @Column(nullable = false)
    private Date rentDateFrom;

    //@NotEmpty(message = "Rent date to cannot be empty.")
    @Column(nullable = false)
    private Date rentDateTo;

    public RequestToRent() {

    }

    public RequestToRent(Long id, Vehicle vehicle, RequestStatusType requestStatusType, NormalUser normalUser, Date rentDateFrom, Date rentDateTo) {
        this.id = id;
        this.vehicle = vehicle;
        this.requestStatusType = requestStatusType;
        this.normalUser = normalUser;
        this.rentDateFrom = rentDateFrom;
        this.rentDateTo = rentDateTo;
    }

    public RequestToRent(RequestToRent requestToRent) {
        this.id = requestToRent.id;
        this.vehicle = requestToRent.vehicle;
        this.requestStatusType = requestToRent.requestStatusType;
        this.normalUser = requestToRent.normalUser;
        this.rentDateFrom = requestToRent.rentDateFrom;
        this.rentDateTo = requestToRent.rentDateTo;
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

    public RequestStatusType getRequestStatusType() {
        return requestStatusType;
    }

    public void setRequestStatusType(RequestStatusType requestStatusType) {
        this.requestStatusType = requestStatusType;
    }

    public NormalUser getNormalUser() {
        return normalUser;
    }

    public void setNormalUser(NormalUser normalUser) {
        this.normalUser = normalUser;
    }

    public Date getRentDateFrom() {
        return rentDateFrom;
    }

    public void setRentDateFrom(Date rentDateFrom) {
        this.rentDateFrom = rentDateFrom;
    }

    public Date getRentDateTo() {
        return rentDateTo;
    }

    public void setRentDateTo(Date rentDateTo) {
        this.rentDateTo = rentDateTo;
    }

    @Override
    public String toString() {
        return "RequestToRent{" +
                "id=" + id +
                ", vehicle=" + vehicle.toString() +
                ", requestStatusType=" + requestStatusType +
                ", user=" + normalUser.toString() +
                ", rentDateFrom=" + rentDateFrom +
                ", rentDateTo=" + rentDateTo +
                '}';
    }

}
