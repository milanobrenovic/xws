package com.xws.tim12.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name = "authentication")
public interface AuthenticationClient {
	 	@PostMapping(value = "/incrementNumberOfAdds/{id}")
	    public ResponseEntity<?> incrementAds(@PathVariable("id") Long id);
	 	
	 	@GetMapping(value = "/role/{role}")
	     public Boolean hasRole(@PathVariable("role") String role,HttpServletRequest request);
	 	
	 
}
