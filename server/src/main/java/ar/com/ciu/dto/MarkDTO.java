package ar.com.ciu.dto;

import java.time.LocalDate;

import ar.com.ciu.model.Mark;

public class MarkDTO {
	private Long id;
	private Integer calification;
	private String unit;
	private LocalDate date;
	private Long idStudentCourse;

	// CONSTRUCTORES
	public MarkDTO() {
		super();
	}

	public MarkDTO(Integer cal, String unit, LocalDate date, Long idStudentCourse) {
		super();
		this.calification = cal;
		this.unit = unit;
		this.date = date;
		this.idStudentCourse = idStudentCourse;
	}

	public MarkDTO(Mark mark) {
		this(mark.getCalification(), mark.getUnit(), mark.getDate(), mark.getStudentCourse().getId());
		this.id = mark.getId();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCalification() {
		return calification;
	}

	public void setCalification(Integer calification) {
		this.calification = calification;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getIdStudentCourse() {
		return idStudentCourse;
	}

	public void setIdStudentCourse(Long idStudentCourse) {
		this.idStudentCourse = idStudentCourse;
	}
	
}
