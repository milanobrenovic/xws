package com.xws.tim12.CarRentService.dto;

public class VehicleRenterDTO {
	
	private Long id;
	
	//id Usera/Agenta koji iznajmljuje
	private Long idUserRenter;

	
	
	public VehicleRenterDTO() {
		super();
	}
	
	
	public VehicleRenterDTO(Long id, Long idUserRenter) {
		super();
		this.id = id;
		this.idUserRenter = idUserRenter;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdUserRenter() {
		return idUserRenter;
	}


	public void setIdUserRenter(Long idUserRenter) {
		this.idUserRenter = idUserRenter;
	}
	
	
	
	
}
