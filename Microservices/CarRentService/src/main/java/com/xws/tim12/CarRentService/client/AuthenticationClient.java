package com.xws.tim12.CarRentService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "authentication")
public interface AuthenticationClient {
	@PostMapping(value = "/incrementNumberOfAdds/{id}")
    public ResponseEntity<?> incrementAds(@PathVariable("id") Long id);
 ;
}
