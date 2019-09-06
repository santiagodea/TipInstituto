package ar.com.ciu.service;

import java.util.List;

import ar.com.ciu.dto.CourseDTO;

public interface CourseService {

	public CourseDTO create(CourseDTO courseDTO);

	public CourseDTO finById(Long idCourse);

	public List<CourseDTO> findAll();

	public CourseDTO update(CourseDTO courseDTO);

	public void delete(Long idCourse);

}
