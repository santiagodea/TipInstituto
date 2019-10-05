package ar.com.ciu.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.com.ciu.model.Mark;
import ar.com.ciu.model.StudentCourse;

public class StudentCourseDTO {

	// atributos
	private Long id;
	private Integer year;
	private Long idStudent;
	private Long idCourse;
	private List<Long> idMarks;

	// CONSTRUCTORES
	public StudentCourseDTO() {
		super();
	}

	public StudentCourseDTO(Integer year, Long idStudent, Long idCourse) {
		super();
		this.year = year;
		this.idStudent = idStudent;
		this.idCourse = idCourse;
		this.idMarks = new ArrayList<Long>();
	}

	public StudentCourseDTO(StudentCourse sc) {
		this(sc.getYear(), sc.getStudent().getId(), sc.getCourse().getId());
		this.id = sc.getId();
	}
	
	public static List<Long> convertMarkToidMark(List<Mark> marks) {
		return marks.stream().map(m -> m.getId()).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public List<Long> getIdMarks() {
		return idMarks;
	}

	public void setIdMarks(List<Long> idMarks) {
		this.idMarks = idMarks;
	}
	
	public void addIdMark(Long idMark) {
		this.idMarks.add(idMark);
	}
	
}
