package ar.com.ciu.dto;

import java.time.LocalDate;

public class MarkUpdateDTO {
	private Long id;
	private double calification;
	private Integer unit;
	private LocalDate date;
	private Long idStudent;
	private Long idCourse;
	private LocalDate date_deleted;

	// CONSTRUCTORES
	public MarkUpdateDTO() {
		super();
	}

	public MarkUpdateDTO(double cal, Integer unit, LocalDate date, Long idStudent, Long idCourse) {
		super();
		this.calification = cal;
		this.unit = unit;
		this.date = date;
		this.idStudent = idStudent;
		this.idCourse = idCourse;
		this.date_deleted = null;
			
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

	public Integer getUnit() {
		return unit;
	}

	public void setDescription(Integer unit) {
		this.unit = unit;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalDate getDate_deleted() {
		return date_deleted;
	}

	public void setDate_deleted(LocalDate date_deleted) {
		this.date_deleted = date_deleted;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
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
}