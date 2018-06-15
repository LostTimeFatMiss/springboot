package com.sym.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootErpApplication.class, args);
	}
}
