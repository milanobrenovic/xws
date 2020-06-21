package com.xws.tim12.client;

import javax.websocket.server.PathParam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "vehicle")
public interface VehicleClient {
	@GetMapping("/{id}")
	public ResponseEntity<?> getVehicle(@PathVariable("id") Long id);
}
