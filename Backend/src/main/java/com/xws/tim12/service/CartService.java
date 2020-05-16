package com.xws.tim12.service;

import java.util.List;
import java.util.Optional;

import com.xws.tim12.dto.CartDTO;
import com.xws.tim12.model.Ad;
import com.xws.tim12.model.Cart;

public interface CartService {
	
	Optional<Cart> findById(Long id);
	
	CartDTO createCart(CartDTO cart);
	
	void removeAdFromCart(Ad ad, Long id);
	
	List<Ad> getAllCartAds(Long id);
	
	void adAd(Ad ad, Long id);
}
