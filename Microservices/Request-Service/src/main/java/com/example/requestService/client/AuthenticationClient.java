package com.example.requestService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "normalUser")
public interface AuthenticationClient {
	 	@PostMapping(value = "/incrementNumberOfAdds/{id}")
	    public ResponseEntity<?> incrementAds(@PathVariable("id") Long id);
}
