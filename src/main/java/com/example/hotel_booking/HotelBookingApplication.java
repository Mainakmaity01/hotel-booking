package com.example.hotel_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.hotel_booking")
@EnableJpaRepositories(basePackages = "com.example.hotel_booking")
public class HotelBookingApplication {
	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApplication.class, args);
	}
}
