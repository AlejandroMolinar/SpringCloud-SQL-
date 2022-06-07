package com.microservicio.proof.app.courses.models.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicio.proof.app.courses.models.entity.Courses;
import com.microservicio.proof.app.courses.models.repository.CourseRepository;
import com.microservicio.proof.commons.services.CommonServiceImpl;


//-----------------------------------------------------------------------------------
//	@Service	-> obtencion, modificacion y eliminacion de datos del Reository (Contenedor de Datos)
//-----------------------------------------------------------------------------------

@Service 
public class CoursesServiceImpl extends CommonServiceImpl<Courses, CourseRepository> implements CoursesService {

	@Override
	@Transactional(readOnly = true)
	public Courses findCouseByStudent(Long id) {
		return repository.findCouseByStudent(id);
	} 

}
