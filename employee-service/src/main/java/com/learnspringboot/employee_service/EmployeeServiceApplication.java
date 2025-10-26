package com.learnspringboot.employee_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	// 1. Bean for RestTemplete
	// @Bean
	// public RestTemplate restTemplate() {
	// return new RestTemplate();
	// }

	// 2.Bean for WebClient
	@Bean
	public WebClient webClient() {
	return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
