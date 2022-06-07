package com.microservicio.proof.commons.examen.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity						//contenedor
@Table(name = "subjects")
public class Subject {
	
//-------------------------ID--------------------------------------------------------   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 	// Auto Incrementable
	private Long id;

//-------------------------Variable--------------------------------------------------   
	@NotEmpty
	@Size(min = 4, max = 30)
	private String name;
	
	// , "handler", "hibernateLazyInitializer" Para evitar posibles errores
	
	@JsonIgnoreProperties(value = {"sonSub", "handler", "hibernateLazyInitializer"})
	@ManyToOne(fetch = FetchType.LAZY)
	private Subject fatherSub;
	
	@JsonIgnoreProperties(value = {"fatherSub", "handler", "hibernateLazyInitializer"}, allowSetters = true)
	@OneToMany(mappedBy = "fatherSub" ,fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
	private List<Subject> sonSub;
	
//-----------------------------------------------------------------------------------   
	
	public Subject() {
		this.sonSub= new ArrayList<>();
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
	
		public Subject getFatherSub() {
			return fatherSub;
		}
	
		public void setFatherSub(Subject fatherSub) {
			this.fatherSub = fatherSub;
		}
	//------------------------------------------------------------------
	
		public List<Subject> getSonSub() {
			return sonSub;
		}
	
		public void setSonSub(List<Subject> sonSub) {
			this.sonSub = sonSub;
		}
		
}
