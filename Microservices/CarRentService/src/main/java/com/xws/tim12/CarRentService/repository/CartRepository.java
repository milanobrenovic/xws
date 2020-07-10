package com.xws.tim12.CarRentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xws.tim12.CarRentService.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	
	Cart findOneById(Long id);
	Cart findOneByUserId(Long id);
}
