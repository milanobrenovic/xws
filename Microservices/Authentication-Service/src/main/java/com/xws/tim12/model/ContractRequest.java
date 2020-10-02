package com.xws.tim12.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.xws.tim12.enumeration.ContractStatus;
import com.xws.tim12.enumeration.TransportationVehicleType;
@Entity
public class ContractRequest {
	 @Id
	 @Column
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 
	 
	 @Column(nullable = false)
	 private Long agencyId1;
	 
	 @Column(nullable = false)
	 private Long agencyId2;
	 @Column
	 private ContractStatus status;
	 
	 
	 
	 
	public ContractRequest() {
		
	}
	public ContractRequest(Long id, Long agencyId1, Long agencyId2, ContractStatus status) {
		super();
		this.id = id;
		this.agencyId1 = agencyId1;
		this.agencyId2 = agencyId2;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAgencyId1() {
		return agencyId1;
	}
	public void setAgencyId1(Long agencyId1) {
		this.agencyId1 = agencyId1;
	}
	public Long getAgencyId2() {
		return agencyId2;
	}
	public void setAgencyId2(Long agencyId2) {
		this.agencyId2 = agencyId2;
	}
	public ContractStatus getStatus() {
		return status;
	}
	public void setStatus(ContractStatus status) {
		this.status = status;
	}
	 
	 
	 
	 
}
