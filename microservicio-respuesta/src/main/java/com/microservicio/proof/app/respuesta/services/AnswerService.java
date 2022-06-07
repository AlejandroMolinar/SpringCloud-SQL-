package com.microservicio.proof.app.respuesta.services;

import com.microservicio.proof.app.respuesta.models.entity.Answer;

public interface AnswerService{
	
	public Iterable<Answer> saveAll(Iterable<Answer> answer);

	public Iterable<Answer> findAnswerByStudentAndExam(Long studentId, Long examId);
	
	public Iterable<Long> findExamAnsweredByStudent(Long studentId);

}
