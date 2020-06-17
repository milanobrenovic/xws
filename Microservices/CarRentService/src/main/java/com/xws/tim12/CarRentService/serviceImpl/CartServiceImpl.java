package com.xws.tim12.CarRentService.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.CarRentService.dto.CartDTO;
import com.xws.tim12.CarRentService.model.Cart;
import com.xws.tim12.CarRentService.model.Vehicle;
import com.xws.tim12.CarRentService.repository.CartRepository;
import com.xws.tim12.CarRentService.repository.VehicleRepository;
import com.xws.tim12.CarRentService.service.CartService;



@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public Cart findById(Long id) {
		if(cartRepository.findOneById(id) == null) {
			return null;
		}
		
		return cartRepository.findOneById(id);
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
	public void removeVehicleFromCart(Vehicle vehicle, Long id) {
		Cart cart = cartRepository.findOneById(id);
		cart.getVehicles().remove(vehicle);
		
		cartRepository.save(cart);
	}
	
	
	public Set<Vehicle> getAllCartVehicles(Long id) {
		Cart cart = cartRepository.findOneById(id);
		Set<Vehicle> vehicles = cart.getVehicles();
		return vehicles;
		//return null;
	}
	
	public CartDTO addVehicleToCart(Long id, Long id2) {
		Cart cart = cartRepository.findOneById(id2);
		
		if(cart == null) {
			System.out.println("cart prazan");
			return null;
		}
		
		Vehicle vehicle = vehicleRepository.findOneById(id);
		
		if(vehicle == null) {
			System.out.println("vehicle prazan");
			return null;
		}
		
		cart.getVehicles().add(vehicle);
		
		Cart newCart = cartRepository.save(cart);

//		return new CartDTO(cartRepository.save(cart));
		return new CartDTO(newCart);
		
	}
					

}