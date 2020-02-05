package ar.com.ciu.service;

import java.util.List;

import ar.com.ciu.dto.CourseWithStudentsDTO;
import ar.com.ciu.dto.ScidDTO;
import ar.com.ciu.dto.StudentCourseDTO;
import ar.com.ciu.model.StudentCourse;

public interface StudentCourseService {
	
	public StudentCourse create(StudentCourse studentCourse);
	
	public StudentCourseDTO create(StudentCourseDTO studentCourseDTO);

	public StudentCourseDTO findById(Long idStudentCourse);

	public List<StudentCourseDTO> findAll();

	public StudentCourseDTO update(StudentCourseDTO studentCourseDTO);

	public void delete(Long idStudentCourse);

	public CourseWithStudentsDTO findByIdWithStudents(Long idCourse);

	public ScidDTO deleteById(ScidDTO scidDTO);

}
