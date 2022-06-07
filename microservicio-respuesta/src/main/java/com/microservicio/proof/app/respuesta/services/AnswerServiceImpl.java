package com.microservicio.proof.app.respuesta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicio.proof.app.respuesta.models.entity.Answer;
import com.microservicio.proof.app.respuesta.models.repository.AnswerRepository;


//-----------------------------------------------------------------------------------
//	@Service	-> obtencion, modificacion y eliminacion de datos del Reository (Contenedor de Datos)
//-----------------------------------------------------------------------------------

@Service 
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired														// Conexion Automatica
	private AnswerRepository repository;
	
//-----------------------------------------------------------------------------------

	@Override
	@Transactional
	public Iterable<Answer> saveAll(Iterable<Answer> answer) {
		return repository.saveAll(answer);
	}

//-----------------------------------------------------------------------------------

	@Override
	@Transactional(readOnly = true)
	public Iterable<Answer> findAnswerByStudentAndExam(Long studentId, Long examId) {
		return repository.findAnswerByStudentAndExam(studentId, examId);
	}

//-----------------------------------------------------------------------------------

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findExamAnsweredByStudent(Long studentId) {
		return repository.findExamAnsweredByStudent(studentId);
	}

}
