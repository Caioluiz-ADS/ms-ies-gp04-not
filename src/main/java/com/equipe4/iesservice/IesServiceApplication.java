package com.equipe4.iesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IesServiceApplication.class, args);
	}
}
