package com.microservicio.proof.app.respuesta.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.microservicio.proof.commons.examen.models.entity.Question;
import com.microservicio.proof.commons.student.models.entity.Student;


//-----------------------------------------------------------------------------------
//	@Entity	->	Entidad Relacional, participacion y relaciones con otras clases	
//	@Table	->	nombre la tabla, esta se encribe toda en Minuscula o en Mayuscula y los 
//				nombres compuestos se separan por un Guion Bajo "_"  
//-----------------------------------------------------------------------------------

@Entity							//contenedor
@Table(name = "answers")		//Para Crear la Tabla en la BBDD
public class Answer {
	
//-------------------------ID--------------------------------------------------------   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	// Auto Incrementable
	private Long id;

//-------------------------Variable--------------------------------------------------   
	@NotEmpty												// Que no este vacio
	private String content;
	
//--------------------------Relaciones-----------------------------------------------   
	@ManyToOne(fetch = FetchType.LAZY)
	private Student student;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Question question;
	
//-------------------------Getter/Setter---------------------------------------------   
	
		public Long getId() {
			return id;
		}
	
		public void setId(Long id) {
			this.id = id;
		}

	//------------------------------------------------------------------
	
		public String getName() {
			return content;
		}
	
		public void setName(String name) {
			this.content = name;
		}
	
	//------------------------------------------------------------------
		
		public Student getStudent() {
			return student;
		}
	
		public void setStudent(Student student) {
			this.student = student;
		}
	
	//------------------------------------------------------------------
		
		public Question getQuestion() {
			return question;
		}
	
		public void setQuestion(Question question) {
		this.question = question;
	}

//-------------------Implements-----------------------------------------------
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Answer)) {
			return false;
		}
		Answer st= (Answer) obj;
		return (this.getId() != null) && (this.getId().equals(st.getId()) );
	}

	
	
}
 





