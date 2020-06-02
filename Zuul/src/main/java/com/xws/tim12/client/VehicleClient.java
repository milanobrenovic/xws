package com.xws.tim12.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xws.tim12.dto.VehicleDTO;

@FeignClient(name = "vehicle")
public interface VehicleClient {

	@GetMapping("/vehicle/{id}")
	VehicleDTO getVehicle(@PathVariable Long id);
}
