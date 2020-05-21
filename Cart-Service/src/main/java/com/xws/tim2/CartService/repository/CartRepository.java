package com.xws.tim2.CartService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim2.CartService.model.Cart;


public interface CartRepository extends JpaRepository<Cart, Long> {
	
	Optional<Cart> findById(Long id);
	
//	List<Ad> findByListOfAdsAndId(Long id);
}

