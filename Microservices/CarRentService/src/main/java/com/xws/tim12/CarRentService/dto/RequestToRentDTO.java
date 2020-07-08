package com.xws.tim12.CarRentService.dto;

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

import com.xws.tim12.CarRentService.enumeration.RequestStatusType;



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
    
	

	public RequestToRentDTO(Long id, RequestStatusType requestStatusType, Long normalUserId, Long vehicleId,
			Date rentDateFrom, Date rentDateTo) {
		super();
		this.id = id;
		this.requestStatusType = requestStatusType;
		this.normalUserId = normalUserId;
		this.vehicleId = vehicleId;
		this.rentDateFrom = rentDateFrom;
		this.rentDateTo = rentDateTo;
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

	
	public Long getVehicleId() {
		return vehicleId;
	}



	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}



	@Override
	public String toString() {
		return "RequestToRentDTO [id=" + id + ", normalUser=" + normalUserId + ", vehicle=" + vehicleId + "]";
	}
    
    
    

}
