package com.xws.tim12.dto;

import java.util.Date;

public class ReservationDate {
	private Date rentDateFrom;
    
    private Date rentDateTo;
    
    public ReservationDate() {
    	
    }
    
	public ReservationDate(Date rentDateFrom, Date rentDateTo) {
		//super();
		this.rentDateFrom = rentDateFrom;
		this.rentDateTo = rentDateTo;
	}
	

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
    
    
    
}
