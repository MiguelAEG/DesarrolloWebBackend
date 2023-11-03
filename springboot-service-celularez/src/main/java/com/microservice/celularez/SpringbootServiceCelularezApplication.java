package com.microservice.celularez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootServiceCelularezApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceCelularezApplication.class, args);
	}

}
