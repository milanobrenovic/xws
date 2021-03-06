package com.xws.tim2.CartService.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim2.CartService.dto.CartDTO;
import com.xws.tim2.CartService.model.Ad;
import com.xws.tim2.CartService.model.Cart;
import com.xws.tim2.CartService.repository.CartRepository;
import com.xws.tim2.CartService.service.CartService;


@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Optional<Cart> findById(Long id) {
		if(cartRepository.findById(id) != null) {
			return null;
		}
		
		return cartRepository.findById(id);
		//return null;
	}

	@Override
	public CartDTO createCart(CartDTO cartDTO) {
		/*if(cartRepository.findById(cartDTO.getId()) != null) {
			return null;
		}*/
		
		Cart newCart = new Cart(cartDTO.getListOfAds());
		
		return new CartDTO(cartRepository.save(newCart));
	}

	@Override
	public void removeAdFromCart(Ad ad, Long id) {
		Optional<Cart> optionalCart = cartRepository.findById(id);
		Cart cart = optionalCart.get();
		cart.getListOfAds().remove(ad);
		
		cartRepository.save(cart);
	}
	
	
	public List<Ad> getAllCartAds(Long id) {
		Optional<Cart> optionalCart = cartRepository.findById(id);
		Cart cart = optionalCart.get();
		List<Ad> ads = cart.getListOfAds();
		return ads;
	}
	
	public void adAd(Ad ad, Long id) {
		Optional<Cart> optionalCart = cartRepository.findById(id);
		Cart cart = optionalCart.get();
		cart.getListOfAds().add(ad);
		cartRepository.save(cart);
	}
					

}