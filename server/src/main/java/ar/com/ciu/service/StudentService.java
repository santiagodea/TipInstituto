package ar.com.ciu.service;

import java.util.List;

import ar.com.ciu.dto.StudentDTO;

public interface StudentService {
	public StudentDTO create(StudentDTO studentDTO);

	public StudentDTO finById(Long idStudent);

	public List<StudentDTO> findAll();

	public StudentDTO update(StudentDTO studentDTO);

	public void delete(Long idStudent);
}
