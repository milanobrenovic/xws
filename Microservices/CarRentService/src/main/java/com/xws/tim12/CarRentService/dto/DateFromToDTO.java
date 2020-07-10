package com.xws.tim12.CarRentService.dto;

import java.util.Date;

public class DateFromToDTO {
	
    private Date rentDateFrom;
    
    private Date rentDateTo;

	public Date getRentDateFrom() {
		return rentDateFrom;
	}

	public void setRentDateFrom(Date rentDateFrom) {
		this.rentDateFrom = rentDateFrom;
	}

	public Date getRentDateTo() {
		return rentDateTo;
	}

	public void setRentDateTo(Date rentDateTo) {
		this.rentDateTo = rentDateTo;
	}

	public DateFromToDTO(Date rentDateFrom, Date rentDateTo) {
		super();
		this.rentDateFrom = rentDateFrom;
		this.rentDateTo = rentDateTo;
	}

	@Override
	public String toString() {
		return "DateFromToDTO{" +
				"rentDateFrom=" + rentDateFrom +
				", rentDateTo=" + rentDateTo +
				'}';
	}
}
