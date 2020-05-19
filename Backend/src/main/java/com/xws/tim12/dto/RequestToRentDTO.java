package com.xws.tim12.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.xws.tim12.enumeration.RequestStatusType;
import com.xws.tim12.model.NormalUser;
import com.xws.tim12.model.Vehicle;

public class RequestToRentDTO {
	
    private Long id;


    private RequestStatusType requestStatusType;
    private NormalUserDTO normalUser;
    private VehicleDTO vehicle;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Agent agent;
    
    @NotEmpty(message = "Rent date from is empty.")
    private Date rentDateFrom;
    
    @NotEmpty(message = "Rent date to is empty.")
    private Date rentDateTo;
    
    public RequestToRentDTO() {
    	
	}
    
	public RequestToRentDTO(Long id, RequestStatusType requestStatusType,
			@NotEmpty(message = "Rent date from is empty.") Date rentDateFrom,
			@NotEmpty(message = "Rent date to is empty.") Date rentDateTo,
			NormalUserDTO normalUser,
			VehicleDTO vehicle) {
		super();
		this.id = id;
		this.requestStatusType = requestStatusType;
		this.rentDateFrom = rentDateFrom;
		this.rentDateTo = rentDateTo;
		this.normalUser = normalUser;
		this.vehicle = vehicle;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RequestStatusType getRequestStatusType() {
		return requestStatusType;
	}

	public void setRequestStatusType(RequestStatusType requestStatusType) {
		this.requestStatusType = requestStatusType;
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

	public NormalUserDTO getNormalUser() {
		return normalUser;
	}

	public void setNormalUser(NormalUserDTO normalUser) {
		this.normalUser = normalUser;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VehicleDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}
    
    
    

}
