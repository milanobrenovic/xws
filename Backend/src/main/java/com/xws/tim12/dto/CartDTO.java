package com.xws.tim12.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.xws.tim12.model.Ad;
import com.xws.tim12.model.Cart;
import com.xws.tim12.model.NormalUser;

public class CartDTO {
	
	private Long id;
	
	private List<Ad> listOfAds;
	
	
	
	public CartDTO() {
		
	}

	public CartDTO(List<Ad> listOfAds) {
		this.listOfAds = listOfAds;
	}
	
	public CartDTO(Cart cart) {
		this(cart.getListOfAds());
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


	public void setListOfAds(List<Ad> listOfAds) {
		this.listOfAds = listOfAds;
	}
	
	
	
}
