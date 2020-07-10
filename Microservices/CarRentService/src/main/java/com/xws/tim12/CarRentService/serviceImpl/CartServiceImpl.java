package com.xws.tim12.CarRentService.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.CarRentService.dto.CartDTO;
import com.xws.tim12.CarRentService.model.Cart;
import com.xws.tim12.CarRentService.repository.CartRepository;
import com.xws.tim12.CarRentService.service.CartService;



@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	

	
	@Override
	public Cart findById(Long id) {
		if(cartRepository.findOneById(id) == null) {
			return null;
		}
		
		return cartRepository.findOneById(id);
		//return null;
	}

	@Override
	public Cart findByUserId(Long id) {
		if(cartRepository.findOneByUserId(id) == null) {
			return null;
		}

		return cartRepository.findOneByUserId(id);
		//return null;
	}

	@Override
	public CartDTO createCart(CartDTO cartDTO) {
		/*if(cartRepository.findById(cartDTO.getId()) != null) {
			return null;
		}*/
		
		Cart newCart = new Cart(cartDTO.getUserId());
		
		return new CartDTO(cartRepository.save(newCart));
		//return null;
	}

	@Override
	public void removeVehicleFromCart(Long vehicle, Long id) {
		Cart cart = cartRepository.findOneById(id);
		cart.getVehicles().remove(vehicle);
		
		cartRepository.save(cart);
	}
	
	
	public ArrayList<Long> getAllCartVehicles(Long id) {
		Cart cart = cartRepository.findOneById(id);
		ArrayList<Long> vehicles = cart.getVehicles();
		return vehicles;
		//return null;
	}
	
	public CartDTO addVehicleToCart(Long id, Long id2) {
		Cart cart = cartRepository.findOneById(id2);
		System.out.println("cart: "+cart);
		if(cart == null) {
			System.out.println("cart prazan");
			return null;
		}
		
		Long vehicle = id;
		
		if(vehicle == null) {
			System.out.println("vehicle prazan");
			return null;
		}
		System.out.println("veh: "+cart.getVehicles());
		cart.getVehicles().add(vehicle);
		
		Cart newCart = cartRepository.save(cart);

//		return new CartDTO(cartRepository.save(cart));
		return new CartDTO(newCart);
		
	}


					

}
