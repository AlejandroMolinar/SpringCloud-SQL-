package com.microservicio.proof.app.examen.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.microservicio.proof.commons.examen.models.entity.Subject;

public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long> {
	
}
