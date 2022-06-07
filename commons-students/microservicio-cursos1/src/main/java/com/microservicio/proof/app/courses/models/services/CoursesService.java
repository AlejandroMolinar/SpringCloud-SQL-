package com.microservicio.proof.app.courses.models.services;

import com.microservicio.proof.app.courses.models.entity.Courses;
import com.microservicio.proof.commons.services.CommonService;

public interface CoursesService extends CommonService<Courses>{
	
	public Courses findCouseByStudent(Long id);
}
