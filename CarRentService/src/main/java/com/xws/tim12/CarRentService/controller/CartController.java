package com.xws.tim12.CarRentService.controller;

import java.util.HashSet;
import java.util.Set;

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

import com.xws.tim12.CarRentService.dto.CartDTO;
import com.xws.tim12.CarRentService.model.Cart;
import com.xws.tim12.CarRentService.model.Vehicle;
import com.xws.tim12.CarRentService.service.CartService;


@RestController
@RequestMapping(value = "/api/cart", produces = MediaType.APPLICATION_JSON_VALUE)
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
	public ResponseEntity<Set<Vehicle>> getAllVehicles(@PathVariable Long id) {
		Set<Vehicle> vehicles = new HashSet<>();
		vehicles = cartService.getAllCartVehicles(id);
		/*return (ResponseEntity<List<Ad>>) ads;*/
		return new ResponseEntity<Set<Vehicle>>(vehicles, HttpStatus.OK);
	}
	
	@PostMapping(value = "/add/{id}/to/{id2}")
	public ResponseEntity<CartDTO> addVehicle(@PathVariable("id") Long id, @PathVariable("id2") Long id2) {
		CartDTO cart = cartService.addVehicleToCart(id, id2);
		
		return new ResponseEntity<CartDTO>(cart, HttpStatus.OK);
	}
}
