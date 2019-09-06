package ar.com.ciu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.ciu.model.StudentCourse;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, Long> {		// Le indico el tipo de dato y la primary key
}
