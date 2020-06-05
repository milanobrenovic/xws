package com.xws.tim12.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authentication")
public interface AuthenticationClient {
	 	@PostMapping(value = "/incrementNumberOfAdds/{id}")
	    public ResponseEntity<?> incrementAds(@RequestHeader("Authorization") String token,
	    		@PathVariable("id") Long id);
}
