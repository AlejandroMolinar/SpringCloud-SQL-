package com.microservicio.proof.app.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "com.microservicio.proof.app.curso.models.entity",
		"com.microservicio.proof.commons.student.models.entity",
		"com.microservicio.proof.commons.examen.models.entity" })
public class MicroservicioCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCursoApplication.class, args);
	}

}