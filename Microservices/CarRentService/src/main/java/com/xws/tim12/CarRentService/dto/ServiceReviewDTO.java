package com.xws.tim12.CarRentService.dto;

import com.xws.tim12.CarRentService.model.ServiceReview;

public class ServiceReviewDTO {
	
	private Long id;
	
	private int stars;
	
	private String subject;
	
	private String description;
	

	public ServiceReviewDTO() {
		super();
	}
	
	public ServiceReviewDTO(int stars, String subject, String description) {
		super();
		this.stars = stars;
		this.subject = subject;
		this.description = description;
	}
	
	public ServiceReviewDTO(Long id, int stars, String subject, String description) {
		super();
		this.id = id;
		this.stars = stars;
		this.subject = subject;
		this.description = description;
	}
	
	public ServiceReviewDTO(ServiceReview s) {
		super();
		this.id = s.getId();
		this.stars = s.getStars();
		this.subject = s.getSubject();
		this.description = s.getDescription();
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
	
}
