package com.xws.tim12.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.xws.tim12.model.Ad;

import net.minidev.json.annotate.JsonIgnore;

public class NormalUserDTO {
	
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

	@NotEmpty(message = "Country is empty.")
    private String country;

	@NotEmpty(message = "Phone number is empty.")
    private String phoneNumber;

	@NotEmpty(message = "Address is empty.")
    private String address;

	@NotEmpty(message = "City is empty.")
    private String city;
	
	//da li treba? (inicijalno 0?)
	@NotEmpty(message = "Number of Adds is empty.")
    private Integer numberOfAds;

    private Boolean isBanned;
    
    //private List<Ad> ads;

    public NormalUserDTO() {
    	
    }

	public NormalUserDTO(Long id, String username, String password, String firstName, String lastName, String email,
			String country, String phoneNumber, String address, String city, Integer numberOfAds, Boolean isBanned) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.numberOfAds = numberOfAds;
		this.isBanned = isBanned;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getNumberOfAds() {
		return numberOfAds;
	}

	public void setNumberOfAds(Integer numberOfAds) {
		this.numberOfAds = numberOfAds;
	}

	public Boolean getIsBanned() {
		return isBanned;
	}

	public void setIsBanned(Boolean isBanned) {
		this.isBanned = isBanned;
	}
	
	

    
    
}
