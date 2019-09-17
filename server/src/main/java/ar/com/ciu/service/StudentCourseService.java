package ar.com.ciu.service;

import java.util.List;

import ar.com.ciu.dto.StudentCourseDTO;

public interface StudentCourseService {
	public StudentCourseDTO create(StudentCourseDTO studentCourseDTO);

	public StudentCourseDTO finById(Long idStudentCourse);

	public List<StudentCourseDTO> findAll();

	public StudentCourseDTO update(StudentCourseDTO studentCourseDTO);

	public void delete(Long idStudentCourse);

}
