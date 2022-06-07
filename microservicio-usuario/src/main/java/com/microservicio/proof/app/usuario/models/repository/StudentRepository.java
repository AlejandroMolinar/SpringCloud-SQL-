package com.microservicio.proof.app.usuario.models.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.microservicio.proof.commons.student.models.entity.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
	// En Repository van los Query o las consultas a la Base de Datos, Get, Post, Put, Delete
	
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
	
//-------------------Find By Name or LastName----------------------------------------
	
	@Query("select s from Student s where s.name like %?1% or s.lastName like %?1%")
	public List<Student> findByNameOrLastName(String name);
	
//-------------------Find By Order By ID Ascendant-----------------------------------
	
	//	El nombre del Metodo tiene palabras clave para Ordenar, 
	//	findAll (Encontrar todo ) By (Por) OrderBy (Ordenar Por) Id (Variable ID) Asc (Ascendente - Ascendent)
	public Iterable<Student> findAllByOrderByIdAsc();
	
//-------------------Find By Order By ID Ascendant Pageable--------------------------
	
	public Page<Student> findAllByOrderByIdAsc(Pageable pageable);
	
}



