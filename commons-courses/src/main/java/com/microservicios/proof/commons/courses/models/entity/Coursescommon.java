package com.microservicios.proof.commons.courses.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//-----------------------------------------------------------------------------------
//	@Entity	->	Entidad Relacional, participacion y relaciones con otras clases	
//	@Table	->	nombre la tabla, esta se encribe toda en Minuscula o en Mayuscula y los 
//				nombres compuestos se separan por un Guion Bajo "_"  
//-----------------------------------------------------------------------------------

@Entity						//contenedor
@Table(name = "courses")		//Para Crear la Tabla en la BBDD
public class Coursescommon {
	
//-------------------------ID--------------------------------------------------------   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	// Auto Incrementable
	private Long id;

//-------------------------Variable--------------------------------------------------   
	private String name;
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

}
 