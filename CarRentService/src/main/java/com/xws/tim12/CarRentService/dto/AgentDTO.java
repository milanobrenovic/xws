package com.xws.tim12.CarRentService.dto;


import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.xws.tim12.CarRentService.enumeration.EntityType;
import com.xws.tim12.CarRentService.model.Ad;
import com.xws.tim12.CarRentService.model.Pricelist;
import com.xws.tim12.CarRentService.model.Vehicle;

public class AgentDTO {
	
	private Long id;

	@NotEmpty(message = "Username is empty.")
    private String username;

	@NotEmpty(message = "Password is empty.")
    private String password;
	
	@NotEmpty(message = "Firstname is empty.")
    private String firstName;
	
	@NotEmpty(message = "Lastname is empty.")
    private String lastName;

	@NotEmpty(message = "Email is empty.")
    private String email;
	
	//Treba validacija ili uopste polje?
    //private EntityType entityType;
    
    @NotEmpty(message = "Company Name is empty.")
    private String companyName;
    
    @NotEmpty(message = "Registration number is empty.")
    private String businessRegistrationNumber;
    
    @NotEmpty(message = "Adress is empty.")
    private String address;
    
    private List<Vehicle> listOfRentedVehicles;
    
    @NotEmpty(message = "Pricelist is empty.")
    private Pricelist pricelist;

    private Boolean isBanned;

    private List<Ad> ads;
 

    public AgentDTO() {

    }
    

    public AgentDTO(Long id, String username, String password, String firstName, String lastName, String email,
                    EntityType entityType, String companyName, String businessRegistrationNumber, String address,
                    List<Vehicle> listOfRentedVehicles, Pricelist pricelist, Boolean isBanned, List<Ad> ads) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		//this.entityType = entityType;
		this.companyName = companyName;
		this.businessRegistrationNumber = businessRegistrationNumber;
		this.address = address;
		this.listOfRentedVehicles = listOfRentedVehicles;
		this.pricelist = pricelist;
		this.isBanned = isBanned;
		this.ads = ads;
	}
    
    public AgentDTO(AgentDTO agent) {
		super();
		this.id = agent.id;
		this.username = agent.username;
		this.password = agent.password;
		this.firstName = agent.firstName;
		this.lastName = agent.lastName;
		this.email = agent.email;
		//this.entityType = agent.entityType;
		this.companyName = agent.companyName;
		this.businessRegistrationNumber = agent.businessRegistrationNumber;
		this.address = agent.address;
		this.listOfRentedVehicles = agent.listOfRentedVehicles;
		this.pricelist = agent.pricelist;
		this.isBanned = agent.isBanned;
		this.ads = agent.ads;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getBusinessRegistrationNumber() {
		return businessRegistrationNumber;
	}


	public void setBusinessRegistrationNumber(String businessRegistrationNumber) {
		this.businessRegistrationNumber = businessRegistrationNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<Vehicle> getListOfRentedVehicles() {
		return listOfRentedVehicles;
	}


	public void setListOfRentedVehicles(List<Vehicle> listOfRentedVehicles) {
		this.listOfRentedVehicles = listOfRentedVehicles;
	}


	public Pricelist getPricelist() {
		return pricelist;
	}


	public void setPricelist(Pricelist pricelist) {
		this.pricelist = pricelist;
	}


	public Boolean getIsBanned() {
		return isBanned;
	}


	public void setIsBanned(Boolean isBanned) {
		this.isBanned = isBanned;
	}


	public List<Ad> getAds() {
		return ads;
	}


	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}
    
	
}
