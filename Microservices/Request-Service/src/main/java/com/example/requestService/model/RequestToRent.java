package com.example.requestService.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import com.example.requestService.enumeration.RequestStatusType;

import java.util.Date;

@Entity
public class RequestToRent {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Long vehicleId;

    @Enumerated(EnumType.STRING)
    private RequestStatusType requestStatusType;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Long normalUserId;

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

    public RequestToRent(Long id, Long vehicle, RequestStatusType requestStatusType, Long normalUser, Date rentDateFrom, Date rentDateTo) {
        this.id = id;
        this.vehicleId = vehicle;
        this.requestStatusType = requestStatusType;
        this.normalUserId = normalUser;
        this.rentDateFrom = rentDateFrom;
        this.rentDateTo = rentDateTo;
    }

    public RequestToRent(RequestToRent requestToRent) {
        this.id = requestToRent.id;
        this.vehicleId = requestToRent.vehicleId;
        this.requestStatusType = requestToRent.requestStatusType;
        this.normalUserId = requestToRent.normalUserId;
        this.rentDateFrom = requestToRent.rentDateFrom;
        this.rentDateTo = requestToRent.rentDateTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicle(Long vehicle) {
        this.vehicleId = vehicle;
    }

    public RequestStatusType getRequestStatusType() {
        return requestStatusType;
    }

    public void setRequestStatusType(RequestStatusType requestStatusType) {
        this.requestStatusType = requestStatusType;
    }

    public Long getNormalUser() {
        return normalUserId;
    }

    public void setNormalUser(Long normalUser) {
        this.normalUserId = normalUser;
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
                ", vehicle=" + vehicleId.toString() +
                ", requestStatusType=" + requestStatusType +
                ", user=" + normalUserId.toString() +
                ", rentDateFrom=" + rentDateFrom +
                ", rentDateTo=" + rentDateTo +
                '}';
    }

}
