package ar.com.ciu.dto;

import java.time.LocalDate;

import ar.com.ciu.model.Mark;

public class MarkDTO {
	private Long id;
	private double calification;
	private String description;
	private LocalDate date;
	private Long idStudentCourse;

	// CONSTRUCTORES
	public MarkDTO() {
		super();
	}

	public MarkDTO(double cal, String description, LocalDate date, Long idStudentCourse) {
		super();
		this.calification = cal;
		this.description = description;
		this.date = date;
		this.idStudentCourse = idStudentCourse;
	}

	public MarkDTO(Mark mark) {
		this(mark.getCalification(), mark.getDescription(), mark.getDate(), mark.getStudentCourse().getId());
		this.id = mark.getId();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCalification() {
		return calification;
	}

	public void setCalification(double calification) {
		this.calification = calification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
