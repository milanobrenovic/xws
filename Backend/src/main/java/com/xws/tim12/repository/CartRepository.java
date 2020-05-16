package com.xws.tim12.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.model.Ad;
import com.xws.tim12.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	Optional<Cart> findById(Long id);
	
//	List<Ad> findByListOfAdsAndId(Long id);
}
