package com.microservicio.proof.app.curso.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.proof.app.curso.models.entity.Course;
import com.microservicio.proof.app.curso.services.CoursesService;
import com.microservicio.proof.commons.controllers.CommonController;
import com.microservicio.proof.commons.examen.models.entity.Exam;
import com.microservicio.proof.commons.student.models.entity.Student;

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
public class CoursesController extends CommonController<Course, CoursesService>{
	
	@Value("$(config.balanceador.test)")
	private String balanceadorTest;
//-----------------------------------------------------------------------------------
	@GetMapping("/balanceador-test")
	public ResponseEntity<?> balanceadorTest() {
		
		Map<String, Object> response= new HashMap<String, Object>();
		response.put("balanceador" , balanceadorTest);
		response.put("cursos" , service.findAll());
		
		return ResponseEntity.ok(response);
	}

//-----------------------------------------------------------------------------------
	@PutMapping("/{id}")																					// Actualizar Cursos por ID
	public ResponseEntity<?> update(@Valid @RequestBody Course course, BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return this.validate(result);
		}
		
		Optional<Course> opCour= service.findById(id);
		
		if (opCour.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Course courseDB= opCour.get();
		courseDB.setName(course.getName());
			
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseDB));
		
	}
	
//-----------------------------------------------------------------------------------
	
		@GetMapping("/student/{id}")																// Buscar cursos por estudiantes
		public ResponseEntity<?> findCouseByStudent(@PathVariable Long id){
			Course courseDB= service.findCouseByStudent(id);
			
			if(courseDB != null) {
				
				List<Long> examsId= (List<Long>) service.findExamAnsweredByStudent(id);
				
				List<Exam> exams= courseDB.getExam()														// la funcion stream revisa los elementos como flujos, a su vez,  
						.stream().map(e -> {																// esta tiene una funcion (maps) que permite modificar este flujo y guardarlo en la BBDD
							
	//------------------------------------------------
    //	Si la lista examsId (que es la Lista que se recibe del MicroServicio-Respuesta) contiene  
	//	el ID del Examen en ese momento del Flujo, entonces, modifica en la Variable Answered (Respondido) a true, 
	//	Es decir, que ese susario ya respondio ese examen, lo cual se guardará en la BBDD,
	//	Para futuras consultas, y de esta manera saber cuales estuadiantes ya Respondieron 
	//	las preguntas del examen y cuales no.
	//
	//  Para eso es el stream().map().collect(Collectors.toList())
	//  Por ultimo, el collect lo que hace es transformar la lista examen modificada en otra lista nueva 
	// 	Que se guardará en "exams"
    //------------------------------------------------
							
							if(examsId.contains(e.getId())) e.setAnswered(true);							 
							return e;
						}).collect(Collectors.toList());
				
				courseDB.setExam(exams);																	// Guarda la Lista modificada a la lista del Curso 
			}																						
			
			
			return ResponseEntity.ok(courseDB);
		}
//-----------------------Student------------------------------------------------------------  
	
	@PutMapping("/{id}/add-student")																		// Agregar estudiantes
	public ResponseEntity<?> addStudents(@RequestBody List<Student> student, @PathVariable Long id){
		Optional<Course> opStu= service.findById(id);
		
		if (opStu.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Course courseDB= opStu.get();
		
		student.forEach(courseDB::addStudent);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseDB));
		
	}
//-----------------------------------------------------------------------------------
	
	@PutMapping("/{id}/remove-student")																		// Eliminar estudiantes
	public ResponseEntity<?> removeStudent(@RequestBody Student course, @PathVariable Long id){
		Optional<Course> opCour= service.findById(id);
		
		if (opCour.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Course courseDB= opCour.get();
		courseDB.removeStudent(course);
			
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseDB));
		
	}

//-----------------------Examenes------------------------------------------------------------  
	
	@PutMapping("/{id}/add-exams")																			// Agregar Examenes en Cursos
	public ResponseEntity<?> addExam(@RequestBody List<Exam> exam, @PathVariable Long id){
		Optional<Course> opStu= service.findById(id);
		
		if (opStu.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Course courseDB= opStu.get();
		
		exam.forEach(courseDB::addExam);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseDB));
		
	}
//-----------------------------------------------------------------------------------
	
	@PutMapping("/{id}/remove-exams")																		// Eliminar Examamens en Cursos
	public ResponseEntity<?> removeExam(@RequestBody Exam exam, @PathVariable Long id){
		Optional<Course> opCour= service.findById(id);
		
		if (opCour.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Course courseDB= opCour.get();
		courseDB.removeExam(exam);
			
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(courseDB));
		
	}

		
}
 