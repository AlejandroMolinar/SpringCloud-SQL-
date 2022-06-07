package com.microservicio.proof.commons.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//-----------------------------------------------------------------------------------
//	Debido a que esta interfaz se quiere hacer generica, se pone despues del nombre de la clase "<E>" 
//  especificando que puede ser implementada en cualquier clase. De esta manera se realizan las Intefaces genericas
//  La "E" Reperenta que es de tipo entity o tipo contenedor 
//-----------------------------------------------------------------------------------

public interface CommonService<E> {
	
	public Iterable<E> findAll();
	
	public Page<E> findAll(Pageable pageable);
		
	public Optional<E> findById(Long id);
		
	public E save(E entity);
	
	public void deleteById(Long id);
}
