package ar.com.ciu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.com.ciu.model.StudentCourse;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, Long> {
	
	@Query("SELECT s FROM StudentCourse s WHERE s.course.id = :id")
	public List<StudentCourse> findByIdCourse(@Param("id") Long id);
	
	@Query("SELECT s FROM StudentCourse s WHERE s.course.id = :idc and s.student.id = :ids")
	public StudentCourse findByIdCourseAndStudent(@Param("idc") Long idc, @Param("ids") Long ids);
	
	//SELECT u FROM User u WHERE u.status = 1")
	
}

