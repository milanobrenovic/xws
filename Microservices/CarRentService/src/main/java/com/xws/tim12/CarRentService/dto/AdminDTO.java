package com.xws.tim12.CarRentService.dto;

import javax.validation.constraints.NotEmpty;

public class AdminDTO {
	
    private Long id;

    @NotEmpty(message = "Username cannot be empty.")
    private String username;


    @NotEmpty(message = "Password cannot be empty.")
    private String password;

    @NotEmpty(message = "First name cannot be empty.")
    private String firstName;
    
    @NotEmpty(message = "Last name cannot be empty.")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty.")
    private String email;
    
    public AdminDTO() {
    	
	}
    
	public AdminDTO(Long id, @NotEmpty(message = "Username cannot be empty.") String username,
			@NotEmpty(message = "Password cannot be empty.") String password,
			@NotEmpty(message = "First name cannot be empty.") String firstName,
			@NotEmpty(message = "Last name cannot be empty.") String lastName,
			@NotEmpty(message = "Email cannot be empty.") String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

}
