package com.microservicio.proof.app.usuario.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicio.proof.app.usuario.models.repository.StudentRepository;
import com.microservicio.proof.commons.services.CommonServiceImpl;
import com.microservicio.proof.commons.student.models.entity.Student;


//-----------------------------------------------------------------------------------
//	@Service	-> obtencion, modificacion y eliminacion de datos del Reository (Contenedor de Datos)
//-----------------------------------------------------------------------------------

@Service 
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService {

//-----------------Encontrar por Nombre o Apellido-----------------------------------
	
	@Override
	@Transactional(readOnly = true)
	public List<Student> findByNameOrLastName(String name) {
		return repository.findByNameOrLastName(name);
	}
//----------------Encontrar Todos los Elementos---------------------------------------

	@Override	
	@Transactional(readOnly = true)
	public Iterable<Student> findAll() {
		return repository.findAllByOrderByIdAsc();
	}
//----------------Encontrar todos los Elementos Paginable-----------------------------

	@Override	
	@Transactional(readOnly = true)
	public Page<Student> findAll(Pageable pageable) {
		return repository.findAllByOrderByIdAsc(pageable);
	}


}
