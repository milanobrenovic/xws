package com.xws.tim12.dto;

import javax.validation.constraints.NotEmpty;

public class PricelistDTO {
	
    private Long id;
    
    @NotEmpty(message = "Price per day is empty.")
    private Double pricePerDay;
    
    public PricelistDTO() {

	}
    
	public PricelistDTO(Long id, @NotEmpty(message = "Price per day is empty.") Double pricePerDay) {
		super();
		this.id = id;
		this.pricePerDay = pricePerDay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	
    
    
}
