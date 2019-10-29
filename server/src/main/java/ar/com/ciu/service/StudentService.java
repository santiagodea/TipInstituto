package ar.com.ciu.service;

import java.util.List;

import ar.com.ciu.dto.StudentDTO;
import ar.com.ciu.model.Student;

public interface StudentService {
	public StudentDTO create(StudentDTO studentDTO);
	
	public Student create(Student student);

	public StudentDTO findById(Long idStudent);

	public List<StudentDTO> findAll();

	public StudentDTO update(StudentDTO studentDTO);

	public void delete(Long idStudent);



}
