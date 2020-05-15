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
	
    private long id;


    private RequestStatusType requestStatusType;


//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Agent agent;
    
    @NotEmpty(message = "Rent date from is empty.")
    private Date rentDateFrom;
    
    @NotEmpty(message = "Rent date to is empty.")
    private Date rentDateTo;
    
    public RequestToRentDTO() {
    	
	}
    
	public RequestToRentDTO(long id, RequestStatusType requestStatusType,
			@NotEmpty(message = "Rent date from is empty.") Date rentDateFrom,
			@NotEmpty(message = "Rent date to is empty.") Date rentDateTo) {
		super();
		this.id = id;
		this.requestStatusType = requestStatusType;
		this.rentDateFrom = rentDateFrom;
		this.rentDateTo = rentDateTo;
	}

	public long getId() {
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
    
    
    

}
