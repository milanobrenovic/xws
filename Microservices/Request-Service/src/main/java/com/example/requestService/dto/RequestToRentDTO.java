package com.example.requestService.dto;

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

import com.example.requestService.enumeration.RequestStatusType;


public class RequestToRentDTO {
	
    private Long id;


    private RequestStatusType requestStatusType;
    private Long normalUserId;
    private Long vehicleId;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Agent agent;
    
    private Date rentDateFrom;
    
    private Date rentDateTo;
    
    public RequestToRentDTO() {
    	
	}
    
	public RequestToRentDTO(Long id, RequestStatusType requestStatusType,
		    Date rentDateFrom,
			Date rentDateTo,
			Long normalUserId,
			Long vehicleId) {
		super();
		this.id = id;
		this.requestStatusType = requestStatusType;
		this.rentDateFrom = rentDateFrom;
		this.rentDateTo = rentDateTo;
		this.normalUserId = normalUserId;
		this.vehicleId = vehicleId;
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

	public Long getNormalUserId() {
		return normalUserId;
	}

	public void setNormalUserId(Long normalUserId) {
		this.normalUserId = normalUserId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVehicle() {
		return vehicleId;
	}

	public void setVehicle(Long vehicle) {
		this.vehicleId = vehicle;
	}

	@Override
	public String toString() {
		return "RequestToRentDTO [id=" + id + ", normalUser=" + normalUserId + ", vehicle=" + vehicleId + "]";
	}
    
    
    

}
