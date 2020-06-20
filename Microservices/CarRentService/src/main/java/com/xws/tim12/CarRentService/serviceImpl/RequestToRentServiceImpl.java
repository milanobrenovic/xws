package com.xws.tim12.CarRentService.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xws.tim12.CarRentService.dto.RequestToRentDTO;
import com.xws.tim12.CarRentService.enumeration.RequestStatusType;
import com.xws.tim12.CarRentService.model.Cart;
import com.xws.tim12.CarRentService.model.RequestToRent;
import com.xws.tim12.CarRentService.model.Vehicle;
import com.xws.tim12.CarRentService.model.VehicleRenter;
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
	
	public Set<RequestToRent> addVehiclesFromCart(Long id) {
//		VehicleUser vehicleUser = vehicleUserRepository.findOneById(id2);
		Cart cart = cartRepository.findOneById(id);
		Set<Vehicle> vehicles = cart.getVehicles();
		
		Long idOfUser = cart.getUserId();
		VehicleUser vehicleUser = vehicleUserRepository.findOneById(idOfUser);
		if(vehicleUser == null) {
			System.out.println("Nema vehicle Usera");
			return null;
		}
		
		List<Vehicle> vehiclesList = new ArrayList<>(vehicles);
		List<Vehicle> vehiclesList2 = vehiclesList;
		Vehicle firstVehicle = vehiclesList.get(0);
		Long idOfFirst = firstVehicle.getId();
		VehicleRenter renterOfFirst = firstVehicle.getVehicleRenter();
		
		RequestToRent newRequest = new RequestToRent();
		
		RequestToRent requestSeparate = new RequestToRent();

		for(Vehicle v : vehiclesList) {
			if(v.getId() != idOfFirst) {
				if(v.getVehicleRenter().getId() == renterOfFirst.getId()) {
					newRequest.getVehicles().add(v);				
				} else {
					requestSeparate.getVehicles().add(v);
				}
			}
		}
		
		Set<RequestToRent> requests = new HashSet<RequestToRent>();
		
		Set<RequestToRent> separateRequests = new HashSet<RequestToRent>();
		
		/*for(Vehicle v1 : vehiclesList) {
			for(Vehicle v2 : vehiclesList2) {
				if(v1.getId() != v2.getId()) {
					if(v1.getVehicleRenter().getId() == v2.getVehicleRenter().getId()) {
						newRequest.getVehicles().add(v1);
						newRequest.getVehicles().add(v2);				
					}
				}
			}
		}
		
		newRequest.setStatus(RequestStatusType.PENDING);
		newRequest.setVehicleUser(vehicleUser);
		requests.add(newRequest);*/
		
		//pravljenje jedng ili vise requestova
		if(!newRequest.getVehicles().isEmpty()) {
			newRequest.getVehicles().add(firstVehicle);
			newRequest.setStatus(RequestStatusType.PENDING);
			newRequest.setVehicleUser(vehicleUser);
			requests.add(newRequest);
			if(!requestSeparate.getVehicles().isEmpty()) {
				for(Vehicle v : requestSeparate.getVehicles()) {
					RequestToRent r = new RequestToRent();
					r.setStatus(RequestStatusType.PENDING);
					r.getVehicles().add(v);
					r.setVehicleRenter(v.getVehicleRenter());
					r.setVehicleUser(vehicleUser);
					requests.add(r);
				}
			}
			
		}else {
			System.out.println("Nema vozila sa istim Renterom");
			for(Vehicle v : vehicles) {
				RequestToRent req = new RequestToRent();
				req.setStatus(RequestStatusType.PENDING);
				req.getVehicles().add(v);
				req.setVehicleRenter(v.getVehicleRenter());
				req.setVehicleUser(vehicleUser);
				requests.add(req);
			}
		}
		
		
//		if(newRequest == null) {
//			return null;
//		}
//		
//		/*requestToRentRepository.save(newRequest);*/
		
		return requests;
	
	}
	
}
