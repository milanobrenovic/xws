package com.xws.tim12;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xws.tim12.security.JwtAuthenticationRequest;

@FeignClient(name = "authentication")
public interface AuthClient {

	@PostMapping("/login")
	String login(@RequestBody String authRequest);
	

    
}
