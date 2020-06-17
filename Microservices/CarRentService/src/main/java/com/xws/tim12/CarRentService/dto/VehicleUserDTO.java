package com.xws.tim12.CarRentService.dto;

public class VehicleUserDTO {
	
	private Long id;
	
	//id Usera/Agenta koji koristi vozilo
	private Long idUser;
		
	private String name;
	
	private String surname;
	
	private String address;

	private String phone;

	
	
	public VehicleUserDTO() {
		super();
	}
	
	public VehicleUserDTO(Long id, Long idUser, String name, String surname, String address, String phone) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
