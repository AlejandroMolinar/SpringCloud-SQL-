package com.microservicio.proof.app.courses.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.microservicio.proof.commons.student.models.entity.Students;

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
@Table(name = "courses")		//Para Crear la Tabla en la BBDD
public class Courses {
	
	//-------------------------ID--------------------------------------------------------   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	// Auto Incrementable
	private Long id;

//-------------------------Variable--------------------------------------------------   
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY)						// Lazy -> Carga perezosa, solo se inicia si es llamada la clase o metodo. (Inicio Retrasado-)					
	private List<Students> student;
//-----------------------------------------------------------------------------------   
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)						// Para guardar en la Variable Date la fecha, dia y hora  
	private Date createAt;
	
	//Este metodo es para que se guarde la fecha en la Variable Date
	@PrePersist
	public void prePersist() {
		// Para eleccionar la Fecha actual
		this.createAt= new Date();
	}
//-----------------------------------------------------------------------------------   
	public Courses() {
		this.student= new ArrayList<>();
	}
	
//-------------------------Getter/Setter---------------------------------------------   
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	//------------------------------------------------------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//------------------------------------------------------------------

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	//------------------------------------------------------------------
	
	public List<Students> getStudent() {
		return student;
	}

	public void setStudent(List<Students> student) {
		this.student = student;
	}
	
	public void addStudent(Students student) {
		this.student.add(student);
	}
	
	public void deleteStudent(Students student) {
		this.student.remove(student);
	}
	
}
 