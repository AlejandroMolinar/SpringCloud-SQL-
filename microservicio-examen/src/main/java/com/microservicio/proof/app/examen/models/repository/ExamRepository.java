package com.microservicio.proof.app.examen.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.microservicio.proof.commons.examen.models.entity.Exam;

public interface ExamRepository extends PagingAndSortingRepository<Exam, Long> {
	
	//-----------------------------------------------------------------------------------
    //	@Query 
	//	join 	-> Ingresa
	//	fetch 	-> Devuelve toda la informacion especificada
	//	where 	-> Cuando 
	//	like 	-> Para buscar algo en especifico en la cadena de caracteres recibida (se agrega despues del where)
	//  %?1%	-> Quiere decir que busque en toda la cadena de caracteres que se recibe al en especifico, desde el principio al final 
	//	_?1_	-> Quiere decir que busca un caractes en especifico en la cadena de caracteres enviada
	//-----------------------------------------------------------------------------------
	//	a.student 	-> con el join fetch se va a recibir toda la información del Estudiante en cuestion a traves de la ID
	//	a.question	-> con el join fetch se va a recibir toda la información de la Pregunta en cuestion a traves de la ID
	//	q.exam		-> con el join fetch se va a recibir toda la información del Examen en cuestion  a traves de la PREGUNTA (question)  
    //-----------------------------------------------------------------------------------
	
	@Query("select e from Exam e where e.name like %?1%")
	public List<Exam> findByName(String name);
}
