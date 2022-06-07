package com.microservicio.proof.app.respuesta.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.microservicio.proof.app.respuesta.models.entity.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
	
	//-----------------------------------------------------------------------------------
    //	@Query 
	//  Select		-> Devuelve algo Especificado
	//	join 		-> Ingresa
	//	fetch 		-> Devuelve toda la informacion especificada
	//	where 		-> Cuando 
	//	like 		-> Para buscar algo en especifico en la cadena de caracteres recibida (se agrega despues del where)
	//  group by	-> Ordenar por 
	//  %?1%		-> Quiere decir que busque en toda la cadena de caracteres que se recibe al en especifico, desde el principio al final 
	//	_?1_		-> Quiere decir que busca un caractes en especifico en la cadena de caracteres enviada
	//-----------------------------------------------------------------------------------
	//	a.student 	-> con el join fetch se va a recibir toda la información del Estudiante en cuestion a traves de la ID
	//	a.question	-> con el join fetch se va a recibir toda la información de la Pregunta en cuestion a traves de la ID
	//	q.exam		-> con el join fetch se va a recibir toda la información del Examen en cuestion  a traves de la PREGUNTA (question)  
    //-----------------------------------------------------------------------------------
	
	
	@Query("select a from Answer a join fetch a.student s join fetch a.question q join fetch q.exam e where s.id=?1 and e.id=?2")
	public Iterable<Answer> findAnswerByStudentAndExam(Long studentId, Long examId);
	
	// "e".id == q.exam "e" 
	@Query("select e.id from Answer a join a.student s join a.question q join q.exam e where e.id=?1 group by e.id")
	public Iterable<Long> findExamAnsweredByStudent(Long studentId);
}
