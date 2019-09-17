package ar.com.ciu.service;

import java.util.List;

import ar.com.ciu.dto.CourseDTO;
import ar.com.ciu.model.Course;

public interface CourseService {

	public CourseDTO create(CourseDTO courseDTO);
	
	public Course create(Course course);

	public CourseDTO finById(Long idCourse);

	public List<CourseDTO> findAll();

	public CourseDTO update(CourseDTO courseDTO);

	public void delete(Long idCourse);

}
