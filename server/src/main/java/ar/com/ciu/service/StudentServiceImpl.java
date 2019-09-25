package ar.com.ciu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ciu.dto.StudentDTO;
import ar.com.ciu.model.Student;
import ar.com.ciu.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	// ATRIBUTOS
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student create(Student student) {
		studentRepository.save(student);
		return student;
	}

	@Override
	public StudentDTO create(StudentDTO studentDTO) {
		Student student = new Student(studentDTO.getDni(), studentDTO.getSurname(), studentDTO.getName(),
				studentDTO.getMail(), studentDTO.getTel_principal(), studentDTO.getTel_secundario());
		this.studentRepository.save(student);
		return new StudentDTO(student);
	}

	@Override
	public StudentDTO findById(Long idStudent) {
		Student student = this.studentRepository.findById(idStudent).orElse(null);
		StudentDTO studentDto = null;
		if (student != null) {
			studentDto = new StudentDTO(student);
		}
		return studentDto;
	}

	@Override
	public StudentDTO update(StudentDTO studentDTO) {
		Student student = this.studentRepository.findById(studentDTO.getId()).get();
		student.setDni(studentDTO.getDni());
		student.setMail(studentDTO.getMail());
		student.setName(studentDTO.getName());
		student.setSurname(studentDTO.getSurname());
		student.setTel_principal(studentDTO.getTel_principal());
		student.setTel_secundario(studentDTO.getTel_secundario());
		student = this.studentRepository.save(student);
		return studentDTO;
	}

	@Override
	public void delete(Long idStudent) {
		this.studentRepository.deleteById(idStudent);

	}

	@Override
	public List<StudentDTO> findAll() {
		List<Student> students = (List<Student>) this.studentRepository.findAll();
		List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
		students.stream().forEach(st -> studentsDTO.add(new StudentDTO(st)));// CORREGIR EL STUDENTdto
		return studentsDTO;
	}
}