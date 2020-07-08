package com.xws.tim12.CarRentService.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.xws.tim12.CarRentService.dto.ServiceReviewDTO;

@Entity
public class ServiceReview {
	
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int stars;
	
	@Column(nullable = false)
	private String subject;
	
	@Column(nullable = false)
	private String description;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private RequestToRent requestToRent;
	
	public ServiceReview() {

	}
	
	
	public ServiceReview(int stars, String subject, String description, RequestToRent requestToRent) {
		super();
		this.stars = stars;
		this.subject = subject;
		this.description = description;
		this.requestToRent = requestToRent;
	}

	public ServiceReview(Long id, int stars, String subject, String description, RequestToRent requestToRent) {
		super();
		this.id = id;
		this.stars = stars;
		this.subject = subject;
		this.description = description;
		this.requestToRent = requestToRent;
	}
	
	public ServiceReview(ServiceReview s) {
		super();
		this.id = s.getId();
		this.stars = s.getStars();
		this.subject = s.getSubject();
		this.description = s.getDescription();
		this.requestToRent = s.getRequestToRent();
	}
	
	public ServiceReview(ServiceReviewDTO s) {
		super();
		this.id = s.getId();
		this.stars = s.getStars();
		this.subject = s.getSubject();
		this.description = s.getDescription();
		this.requestToRent = null;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RequestToRent getRequestToRent() {
		return requestToRent;
	}

	public void setRequestToRent(RequestToRent requestToRent) {
		this.requestToRent = requestToRent;
	}
	
	
}
