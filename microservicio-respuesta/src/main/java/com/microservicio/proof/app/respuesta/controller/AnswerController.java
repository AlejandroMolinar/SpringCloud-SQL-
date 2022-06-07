package com.microservicio.proof.app.respuesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.proof.app.respuesta.models.entity.Answer;
import com.microservicio.proof.app.respuesta.models.repository.AnswerRepository;



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
public class AnswerController {
	
	@Autowired
	private AnswerRepository repository;
	
//-----------------------------------------------------------------------------------

	@PostMapping
	public ResponseEntity<?> saveAll(@RequestBody Iterable<Answer> answer){
		Iterable<Answer> answerDB= repository.saveAll(answer);
		return ResponseEntity.status(HttpStatus.CREATED).body(answerDB);
	}
	
//-----------------------------------------------------------------------------------
	
	@GetMapping("/student/{studentId}/exam/{examId}")
	public ResponseEntity<?> findAnswerByStudentAndExam(@PathVariable Long studentId,@PathVariable Long examId){
		Iterable<Answer> answerDB= repository.findAnswerByStudentAndExam(studentId, examId);
		return ResponseEntity.ok(answerDB);		
	}
	
//-----------------------------------------------------------------------------------
	
	@GetMapping("/student/{studentId}/exam-answered")
	public ResponseEntity<?>  findExamAnsweredByStudent(@PathVariable Long studentId){
		Iterable<Long> answerDB= repository.findExamAnsweredByStudent(studentId);
		return ResponseEntity.ok(answerDB);		
	}

}
 