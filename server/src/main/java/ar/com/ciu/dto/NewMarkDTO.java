package ar.com.ciu.dto;

import java.time.LocalDate;

public class NewMarkDTO {

	private Long idCourse;
	private Long idStudent;
	private Integer unit;
	private double mark;
	private LocalDate date;

	public NewMarkDTO(Long idCourse, Long idStudent, Integer unit, double mark, LocalDate date) {
		super();
		this.idCourse = idCourse;
		this.idStudent = idStudent;
		this.unit = unit;
		this.mark = mark;
		this.date = date;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
