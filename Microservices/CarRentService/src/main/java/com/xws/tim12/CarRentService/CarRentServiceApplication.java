package com.xws.tim12.CarRentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class CarRentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentServiceApplication.class, args);
	}

}
