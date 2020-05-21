package com.xws.tim2.CartService.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Ad> listOfAds;

	public Cart() {
		
	}

	public Cart(List<Ad> listOfAds) {
		super();
		this.listOfAds = listOfAds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Ad> getListOfAds() {
		return listOfAds;
	}

	public void setListOfAds(List<Ad> ads) {
		this.listOfAds = ads;
	}
	
	
	
	
}