package com.microservicio.proof.app.usuario.services;

import java.util.List;

import com.microservicio.proof.commons.services.CommonService;
import com.microservicio.proof.commons.student.models.entity.Student;

public interface StudentService extends CommonService<Student>{
	
	public List<Student> findByNameOrLastName(String name);
	
	
}
