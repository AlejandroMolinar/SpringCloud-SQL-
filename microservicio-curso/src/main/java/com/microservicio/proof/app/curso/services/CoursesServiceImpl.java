package com.microservicio.proof.app.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicio.proof.app.curso.client.AnswerFeignClient;
import com.microservicio.proof.app.curso.models.entity.Course;
import com.microservicio.proof.app.curso.models.repository.CourseRepository;
import com.microservicio.proof.commons.services.CommonServiceImpl;


//-----------------------------------------------------------------------------------
//	@Service	-> obtencion, modificacion y eliminacion de datos del Reository (Contenedor de Datos)
//-----------------------------------------------------------------------------------

@Service 
public class CoursesServiceImpl extends CommonServiceImpl<Course, CourseRepository> implements CoursesService {
	
	@Autowired
	private AnswerFeignClient client;
//-----------------------------------------------------------------------------------
	
	@Override
	@Transactional(readOnly = true)
	public Course findCouseByStudent(Long id) {
		return repository.findCouseByStudent(id);
	}
	
//-----------------------------------------------------------------------------------

	@Override																			// En este Caso no va el @Transactional  
	public Iterable<Long> findExamAnsweredByStudent(Long studentId) {					// porque no es una conexion a la Base de Datos,
		return client.findExamAnsweredByStudent(studentId);								// es decir, no leera de la BBDD o crear algo 
	} 
	
//-----------------------------------------------------------------------------------

}
