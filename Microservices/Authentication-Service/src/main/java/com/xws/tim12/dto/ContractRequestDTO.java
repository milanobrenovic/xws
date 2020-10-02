package com.xws.tim12.dto;

import javax.validation.constraints.NotEmpty;

import com.xws.tim12.enumeration.ContractStatus;

import net.minidev.json.annotate.JsonIgnore;

public class ContractRequestDTO {
	private Long id;
	
	
    private Long agencyId1;

	
	
    private Long agencyId2;

    private ContractStatus status;

    
    
	public ContractRequestDTO() {
		
	}



	public ContractStatus getStatus() {
		return status;
	}



	public void setStatus(ContractStatus status) {
		this.status = status;
	}



	public ContractRequestDTO(Long id, Long agencyId1, Long agencyId2, ContractStatus status) {
		super();
		this.id = id;
		this.agencyId1 = agencyId1;
		this.agencyId2 = agencyId2;
		this.status = status;
	}



	public ContractRequestDTO(Long id, Long agencyId1, Long agencyId2) {
		super();
		this.id = id;
		this.agencyId1 = agencyId1;
		this.agencyId2 = agencyId2;
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
    
    
}
