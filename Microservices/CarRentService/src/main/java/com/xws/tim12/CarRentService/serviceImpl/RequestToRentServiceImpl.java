package com.xws.tim12.CarRentService.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.CarRentService.dto.RequestToRentDTO;
import com.xws.tim12.CarRentService.enumeration.RequestStatusType;
import com.xws.tim12.CarRentService.model.Cart;
import com.xws.tim12.CarRentService.model.RequestToRent;
import com.xws.tim12.CarRentService.model.Vehicle;
import com.xws.tim12.CarRentService.model.VehicleUser;
import com.xws.tim12.CarRentService.repository.CartRepository;
import com.xws.tim12.CarRentService.repository.RequestToRentRepository;
import com.xws.tim12.CarRentService.repository.VehicleUserRepository;
import com.xws.tim12.CarRentService.service.RequestToRentService;

@Service
public class RequestToRentServiceImpl implements RequestToRentService {
	
	@Autowired 
	private RequestToRentRepository requestToRentRepository;
	
	@Autowired 
	private CartRepository cartRepository;
	
	@Autowired 
	private VehicleUserRepository vehicleUserRepository;

	@Override
	public RequestToRent findById(Long id) {
		if(requestToRentRepository.findOneById(id) == null) {
			return null;
		}
		
		return requestToRentRepository.findOneById(id);
	}
	
	@Override
	public RequestToRentDTO createRequest(RequestToRentDTO requestDTO) {
		RequestToRent newRequest = new RequestToRent(requestDTO);
		
		return new RequestToRentDTO(requestToRentRepository.save(newRequest));
		//return null;
	}
	
	
	public RequestToRent addVehicleFromCart(Long id, Long id2) {
//		VehicleUser vehicleUser = vehicleUserRepository.findOneById(id2);
		Cart cart = cartRepository.findOneById(id2);
		Set<Vehicle> vehicles = cart.getVehicles();
		
		Vehicle requestVehicle = new Vehicle();
		
		for(Vehicle v : vehicles) {
			if(v.getId() == id) {
				requestVehicle = v;
				break;
			}
		}
		
		if(requestVehicle == null) {
			System.out.println("Ne postoji vozilo u korpi sa takvim ID-om.");
			return null;
		}
		
		RequestToRent newRequest = new RequestToRent();
		newRequest.getVehicles().add(requestVehicle);
		newRequest.setStatus(RequestStatusType.PENDING);
		newRequest.setVehicleRenter(requestVehicle.getVehicleRenter());
		
		VehicleUser vehicleUser = vehicleUserRepository.findOneById(cart.getUserId());
		newRequest.setVehicleUser(vehicleUser);
		
		if(newRequest == null) {
			return null;
		}
		
		requestToRentRepository.save(newRequest);
		
		return newRequest;
	
		
	}
	
	public RequestToRent addVehiclesFromCart(Long id) {
//		VehicleUser vehicleUser = vehicleUserRepository.findOneById(id2);
		Cart cart = cartRepository.findOneById(id);
		Set<Vehicle> vehicles = cart.getVehicles();
		
		
//		Long idOfFirst = vehicles.
		
		
		
		RequestToRent newRequest = new RequestToRent();
		
		
		
		newRequest.setVehicles(vehicles);
		newRequest.setStatus(RequestStatusType.PENDING);
		
		if(newRequest == null) {
			return null;
		}
		
		/*requestToRentRepository.save(newRequest);*/
		
		return newRequest;
	
	}
	
}
