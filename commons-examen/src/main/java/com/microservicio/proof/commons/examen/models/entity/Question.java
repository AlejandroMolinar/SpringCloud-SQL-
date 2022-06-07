package com.microservicio.proof.commons.examen.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//-----------------------------------------------------------------------------------
//	@Entity	->	Entidad Relacional, participacion y relaciones con otras clases	
//	@Table	->	nombre la tabla, esta se encribe toda en Minuscula o en Mayuscula y los 
//				nombres compuestos se separan por un Guion Bajo "_"  
//
//	Tipos de Relaciones 
//
//	@OneToOne		->	uno por uno, realciones de 1 de Algo por 1 de otro, Ej: 1 curso por 1 Alumno  
//	@OneToMany		->	uno por varios, realciones de 1 de Algo por varios de otro, Ej: 1 curso por Varios Alumnos  
//	@ManyToOne		->	Varios por uno, realciones de Varios de Algo por 1 de otro, Ej: 1  Varios Alumnos por 1 Curso  
//	@ManyToMany		->	Varios por Varios, realciones de VArios de Algo por Varios de otro, Ej:  Varios Alumnos por  Varios Cursos  
//
//-----------------------------------------------------------------------------------

@Entity						//contenedor
@Table(name = "questions")		//Para Crear la Tabla en la BBDD
public class Question {
	
//-------------------------ID--------------------------------------------------------   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	// Auto Incrementable
	private Long id;

//-------------------------Variable--------------------------------------------------   
	private String content;
	
	@JsonIgnoreProperties(value = {"question"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "exam_id")		// LLave foranea 
	private Exam exam;
//-------------------------Getter/Setter---------------------------------------------   
		
		public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}
	//------------------------------------------------------------------
	
		public String getContent() {
			return content;
		}
	
		public void setContent(String content) {
			this.content = content;
		}
	
	//------------------------------------------------------------------
		
		public Exam getExam() {
			return exam;
		}
	
		public void setExam(Exam exam) {
			this.exam = exam;
		}
	
		
		@Override
		public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(!(this instanceof Question)) {
			return false;
		}
		Question qt= (Question) obj;
		return (this.getId() != null) && (this.getId().equals(qt.getId()));
	}


}
 