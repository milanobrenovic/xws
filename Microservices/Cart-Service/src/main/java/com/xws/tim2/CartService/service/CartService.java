package com.xws.tim2.CartService.service;

import java.util.List;
import java.util.Optional;

import com.xws.tim2.CartService.dto.CartDTO;
import com.xws.tim2.CartService.model.Ad;
import com.xws.tim2.CartService.model.Cart;


public interface CartService {
	
	Optional<Cart> findById(Long id);
	
	CartDTO createCart(CartDTO cart);
	
	void removeAdFromCart(Ad ad, Long id);
	
	List<Ad> getAllCartAds(Long id);
	
	void adAd(Ad ad, Long id);
}
