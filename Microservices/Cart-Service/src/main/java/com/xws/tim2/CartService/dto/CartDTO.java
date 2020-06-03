package com.xws.tim2.CartService.dto;

import java.util.List;

import com.xws.tim2.CartService.model.Ad;
import com.xws.tim2.CartService.model.Cart;


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
