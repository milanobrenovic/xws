package com.xws.tim12.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xws.tim12.dto.CartDTO;
import com.xws.tim12.model.Ad;
import com.xws.tim12.model.Cart;
import com.xws.tim12.repository.CartRepository;
import com.xws.tim12.service.AdService;
import com.xws.tim12.service.CartService;


@RestController
@RequestMapping(value = "/api/auth/cart")
public class CartController {
	
	@Autowired
    private CartService cartService;
	
	@Autowired
	private AdService adService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDTO> create(@RequestBody CartDTO cartDTO) {
		CartDTO createdCart = cartService.createCart(cartDTO);
        if (createdCart == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<CartDTO>(createdCart, HttpStatus.CREATED);
    }
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, 
			value="/allAds/{id}")
	public ResponseEntity<List<Ad>> getAllAds(@PathVariable Long id) {
		List<Ad> ads = new ArrayList<>();
		ads = cartService.getAllCartAds(id);
		/*return (ResponseEntity<List<Ad>>) ads;*/
		return new ResponseEntity<List<Ad>>(ads, HttpStatus.CREATED);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, 
			value="/{id}")
	public ResponseEntity<List<Ad>> adAd(@PathVariable Long id) {
		return null;
	}
}
