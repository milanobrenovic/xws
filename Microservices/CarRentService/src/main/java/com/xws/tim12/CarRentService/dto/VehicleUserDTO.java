package com.xws.tim12.CarRentService.dto;

import com.xws.tim12.CarRentService.model.VehicleUser;

public class VehicleUserDTO {
	
	private Long id;
	
	//id Usera/Agenta koji koristi vozilo
	private Long idUser;

	
	
	public VehicleUserDTO() {
		super();
	}
	
	public VehicleUserDTO(Long id, Long idUser) {
		super();
		this.id = id;
		this.idUser = idUser;
	}
	
	public VehicleUserDTO(VehicleUser v) {
		super();
		this.id = v.getId();
		this.idUser = v.getId();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	
	
}
