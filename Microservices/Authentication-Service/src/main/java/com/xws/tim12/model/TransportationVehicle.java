package com.xws.tim12.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.xws.tim12.enumeration.TransportationVehicleType;

@Entity
public class TransportationVehicle {
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;
    
    private TransportationVehicleType type;
    @ElementCollection(targetClass=Long.class)
    private List<Long> agencyIdReservation = new ArrayList<Long>();
    @ElementCollection(targetClass=Date.class)
    private List<Date> startDates = new ArrayList<Date>();
    @ElementCollection(targetClass=Date.class)
	private List<Date> endDates = new ArrayList<Date>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   	private Agency agency;

    
	
	

	
    private TransportationVehicle() {
    	
    }
	

	

	

	public TransportationVehicle(Long id, String brand, String model, TransportationVehicleType type) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.type = type;
	}






	public TransportationVehicle(Long id, String brand, String model, TransportationVehicleType type,
			List<Long> agencyId, List<Date> startDates, List<Date> endDates, Agency agency) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.agencyIdReservation = agencyId;
		this.startDates = startDates;
		this.endDates = endDates;
		this.agency = agency;
	}
	



	public List<Date> getStartDates() {
		return startDates;
	}



	public void setStartDates(List<Date> startDates) {
		this.startDates = startDates;
	}



	public List<Date> getEndDates() {
		return endDates;
	}



	public void setEndDates(List<Date> endDates) {
		this.endDates = endDates;
	}



	



	public List<Long> getAgencyId() {
		return agencyIdReservation;
	}



	public void setAgencyId(List<Long> agencyId) {
		this.agencyIdReservation = agencyId;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public TransportationVehicleType getType() {
		return type;
	}

	public void setType(TransportationVehicleType type) {
		this.type = type;
	}

	

	


	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	
	
}
