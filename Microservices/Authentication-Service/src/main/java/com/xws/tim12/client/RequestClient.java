package com.xws.tim12.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "car-rent-microservice")
public interface RequestClient {
	@GetMapping(value="/userGrades/{id}")
	public Double getGradesOfUser(@PathVariable("id") Long id);
	
	
}
