package com.travelzilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
servers = {@Server(url = "/", description = "Default Server URL")})
public class TravelZillaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelZillaApplication.class, args);
		
		System.out.println("Start");
		
	}

}
