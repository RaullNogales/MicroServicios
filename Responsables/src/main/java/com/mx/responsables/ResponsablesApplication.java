package com.mx.responsables;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ResponsablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResponsablesApplication.class, args);
	}

}
