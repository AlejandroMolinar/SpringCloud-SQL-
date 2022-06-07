package com.microservicio.proof.app.respuesta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "com.microservicio.proof.app.respuesta.models.entity",
		"com.microservicio.proof.commons.student.models.entity",
		"com.microservicio.proof.commons.examen.models.entity" })
public class MicroservicioRespuestaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioRespuestaApplication.class, args);
	}

}
