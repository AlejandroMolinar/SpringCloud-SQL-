package com.microservicio.proof.app.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicio.proof.app.examen.models.repository.ExamRepository;
import com.microservicio.proof.app.examen.models.repository.SubjectRepository;
import com.microservicio.proof.commons.examen.models.entity.Exam;
import com.microservicio.proof.commons.examen.models.entity.Subject;
import com.microservicio.proof.commons.services.CommonServiceImpl;


//-----------------------------------------------------------------------------------
//	@Service	-> obtencion, modificacion y eliminacion de datos del Reository (Contenedor de Datos)
//-----------------------------------------------------------------------------------

@Service 
public class ExamServiceImpl extends CommonServiceImpl<Exam, ExamRepository> implements ExamService {
	
	@Autowired																		// Auto Conexion
	private SubjectRepository subjectRepository;
//------------------------------------------------------------------

	@Override
	@Transactional(readOnly = true)
	public List<Exam> findByName(String name) {
		return repository.findByName(name);
	}
//------------------------------------------------------------------

	@Override
	@Transactional(readOnly = true)
	public Iterable<Subject> findAllSubjects() {
		return subjectRepository.findAll();
	}



}
