package com.example.requestService.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "vehicle")
public interface VehicleClient {
	@GetMapping(path= "/vehicleOfUser/{id}")
	public List<Long> getVehicleOfUser(@PathVariable("id") Long id);
}
