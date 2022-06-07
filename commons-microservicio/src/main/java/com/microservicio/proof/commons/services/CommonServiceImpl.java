package com.microservicio.proof.commons.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;


//-----------------------------------------------------------------------------------
//	@Service	-> obtencion, modificacion y eliminacion de datos del Reository (Contenedor de Datos)
//	
//	Clase implemetada por la interfaz StudentService, la cual es generica y por el mismo motivo, 
//	esta clase tambien se quiere generica, por lo cual le le agrega:
//	
//	la "E" de entity 
//	El CrudRepository que se entiende en la variable de tipo Repository
//
//	A su vez, la clase CrudRepository es generica(E) y recibe un tipo ID(Long)
//
//	Es importente tener en cuenta que estas clases genericas cuando se implementen en otra clase o proyecto, 
//	esta estará pidiendo una variable o metodo de tipo entity y otra que extienda de CrudRepository
//-----------------------------------------------------------------------------------

public class CommonServiceImpl<E, Repository extends PagingAndSortingRepository<E, Long>> implements CommonService<E> { 
	
	@Autowired
	protected Repository repository;
//-----------------------------------------------------------------------------------

	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {
		return repository.findAll();
	}
//-----------------------------------------------------------------------------------
	
	@Override
	@Transactional(readOnly = true)
	public Page<E> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
//-----------------------------------------------------------------------------------

	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Long id) {
		return repository.findById(id);
	}
//-----------------------------------------------------------------------------------

	@Override
	@Transactional
	public E save(E entity) {
		return repository.save(entity);
	}
//-----------------------------------------------------------------------------------

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);

	}


}
