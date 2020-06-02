package com.xws.tim12;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xws.tim12.security.JwtAuthenticationRequest;

@FeignClient(name = "authentication")
public interface AuthClient {

	@PostMapping("/login")
	String login(@RequestBody String authRequest);
}
