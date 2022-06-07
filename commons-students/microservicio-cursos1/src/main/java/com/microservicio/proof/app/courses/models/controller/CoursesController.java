package com.microservicio.proof.app.courses.models.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.proof.app.courses.models.entity.Courses;
import com.microservicio.proof.app.courses.models.services.CoursesService;
import com.microservicio.proof.commons.controllers.CommonController;
import com.microservicio.proof.commons.student.models.entity.Students;


//-----------------------------------------------------------------------------------
//	@RestController	->	Controla la Info y la envia en un Archivo JSon
//
//	@PostMapping		->	Agregar un elemento, es diferente del Put. 	(Create)
//	@GetMapping			->	Leer o recoger datos en general 			(Read)
//	@PutMapping			->	Modifica un elemento en especifico 			(Uodate)
//	@DeleteMapping		->	Eliminar un elemeno en especifico 			(Delete)
//
//-----------------------------------------------------------------------------------

@RestController										// Controlador de Soporte	
public class CoursesController extends CommonController<Courses, CoursesService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Courses course, @PathVariable Long id){
		Optional<Courses> opCour= service.findById(id);
		
		if (opCour.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Courses courseDB= opCour.get();
		courseDB.setName(course.getName());
			
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseDB));
		
	}
	
	@PutMapping("/{id}/add-students")
	public ResponseEntity<?> addStudents(@RequestBody List<Students> student, @PathVariable Long id){
		Optional<Courses> opStu= service.findById(id);
		
		if (opStu.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Courses courseDB= opStu.get();
		
		student.forEach(a -> {
			courseDB.addStudent(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseDB));
		
	}
	
	@PutMapping("/{id}/delete-student")
	public ResponseEntity<?> deleteStudent(@RequestBody Students course, @PathVariable Long id){
		Optional<Courses> opCour= service.findById(id);
		
		if (opCour.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Courses courseDB= opCour.get();
		courseDB.deleteStudent(course);
			
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseDB));
		
	}
	
	@GetMapping("/courses-student/{id}")
	public ResponseEntity<?> findCouseByStudent(@PathVariable Long id){
		Courses courses= service.findCouseByStudent(id);
		return ResponseEntity.ok(courses);
	}

		
}
 