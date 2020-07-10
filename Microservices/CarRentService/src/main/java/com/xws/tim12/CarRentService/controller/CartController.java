package com.xws.tim12.CarRentService.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.xws.tim12.CarRentService.dto.CartDTO;
import com.xws.tim12.CarRentService.model.Cart;
import com.xws.tim12.CarRentService.service.CartService;


@RestController
//@RequestMapping(value = "/api/cart", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = { "http://localhost:4200" })
public class CartController {
	
	@Autowired
    private CartService cartService;
	
	/*@Autowired
	private VehicleService vehicleService;*/
	
//	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value = "/create")
    public ResponseEntity<CartDTO> create(@RequestBody CartDTO cartDTO) {
		CartDTO createdCart = cartService.createCart(cartDTO);
        if (createdCart == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<CartDTO>(createdCart, HttpStatus.CREATED);
    }

	@GetMapping(value = "/getCart/{userId}")
	public Boolean getCartt(@PathVariable Long userId) {
		Cart cart = cartService.findByUserId(userId);

		if (cart == null) {
			return false;
		}
		return true;
	}

	@GetMapping(value = "/getCartId/{userId}")
	public Long getCartId(@PathVariable Long userId) {
		Long cartId = cartService.findByUserId(userId).getId();

		if (cartId == null) {
			return null;
		}
		return cartId;
	}

	@GetMapping(value = "/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
		Cart cart = cartService.findById(id);

        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
    }
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, 
			value="/allVehicles/{id}")
	public ResponseEntity<ArrayList<Long>> getAllVehicles(@PathVariable Long id) {
		ArrayList<Long> vehicles = new ArrayList<>();
		vehicles = cartService.getAllCartVehicles(id);
		/*return (ResponseEntity<List<Ad>>) ads;*/
		return new ResponseEntity<ArrayList<Long>>(vehicles, HttpStatus.OK);
	}
	
	@PostMapping(value = "/add/{id}/to/{id2}")
	public ResponseEntity<CartDTO> addVehicle(@PathVariable("id") Long id, @PathVariable("id2") Long id2) {
		CartDTO cart = cartService.addVehicleToCart(id, id2);
		
		return new ResponseEntity<CartDTO>(cart, HttpStatus.OK);
	}
}
