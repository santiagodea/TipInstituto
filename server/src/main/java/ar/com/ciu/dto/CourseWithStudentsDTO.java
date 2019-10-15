package ar.com.ciu.dto;

import java.util.List;
import java.util.stream.Collectors;

import ar.com.ciu.model.Course;
import ar.com.ciu.model.Student;

public class CourseWithStudentsDTO {

	// ATRIBUTOS
	private CourseDTO courseDTO;
	private List<StudentDTO> studentListDTO;

	public CourseWithStudentsDTO() {
		super();
	}

	public CourseWithStudentsDTO(Course course, List<Student> listStudent) {
		super();
		this.courseDTO = new CourseDTO(course);
		this.studentListDTO = this.convertToDTO(listStudent);
	}

	private List<StudentDTO> convertToDTO(List<Student> listStudent) {
		List<StudentDTO> listDTOs = listStudent.stream().map(s -> new StudentDTO(s)).collect(Collectors.toList());
		return listDTOs;
	}

	public CourseDTO getCourseDTO() {
		return courseDTO;
	}

	public void setCourseDTO(CourseDTO courseDTO) {
		this.courseDTO = courseDTO;
	}

	public List<StudentDTO> getStudentListDTO() {
		return studentListDTO;
	}

	public void setStudentListDTO(List<StudentDTO> studentListDTO) {
		this.studentListDTO = studentListDTO;
	}

}
