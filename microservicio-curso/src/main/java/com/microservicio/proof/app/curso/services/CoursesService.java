package com.microservicio.proof.app.curso.services;

import com.microservicio.proof.app.curso.models.entity.Course;
import com.microservicio.proof.commons.services.CommonService;

public interface CoursesService extends CommonService<Course>{
	
	public Course findCouseByStudent(Long id);
	
	public Iterable<Long> findExamAnsweredByStudent(Long studentId);
}
