package com.mx.mascotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MascotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MascotasApplication.class, args);
	}

}
