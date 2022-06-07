package com.microservicio.proof.app.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.microservicio.proof.commons.examen.models.entity"})
public class MicroservicioExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioExamenApplication.class, args);
	}

}
