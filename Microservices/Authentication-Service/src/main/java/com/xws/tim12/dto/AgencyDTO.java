package com.xws.tim12.dto;

public class AgencyDTO {
	private Long id;
	private String agencyName;
	
	
	public AgencyDTO(Long id, String agencyName) {
		super();
		this.id = id;
		this.agencyName = agencyName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	
	
	
}
