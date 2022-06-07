package com.microservicio.proof.app.curso.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-respuesta")
public interface AnswerFeignClient {
	
	@GetMapping("/student/{studentId}/exam-answered")
	public Iterable<Long> findExamAnsweredByStudent(@PathVariable Long studentId);
}
