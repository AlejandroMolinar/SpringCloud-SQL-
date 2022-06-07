package com.microservicio.proof.app.examen.services;

import java.util.List;

import com.microservicio.proof.commons.examen.models.entity.Exam;
import com.microservicio.proof.commons.examen.models.entity.Subject;
import com.microservicio.proof.commons.services.CommonService;

public interface ExamService extends CommonService<Exam>{
	
	public List<Exam> findByName(String name);
	
	public Iterable<Subject> findAllSubjects();

}
