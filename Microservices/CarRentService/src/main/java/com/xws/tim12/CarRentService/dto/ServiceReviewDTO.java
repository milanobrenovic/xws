package com.xws.tim12.CarRentService.dto;

public class ServiceReviewDTO {
	
	private Long id;
	
	private int stars;
	
	private String description;
	
	

	public ServiceReviewDTO() {
		super();
	}
	
	public ServiceReviewDTO(Long id, int stars, String description) {
		super();
		this.id = id;
		this.stars = stars;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
