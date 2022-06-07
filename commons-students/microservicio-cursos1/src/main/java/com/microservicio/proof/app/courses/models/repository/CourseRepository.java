package com.microservicio.proof.app.courses.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.microservicio.proof.app.courses.models.entity.Courses;

public interface CourseRepository extends CrudRepository<Courses, Long> {
	
	@Query("select c from Courses c join fetch c.student a where a.id= ?1 ")
	public Courses findCouseByStudent(Long id);
}
