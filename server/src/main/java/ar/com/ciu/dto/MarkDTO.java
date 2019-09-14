package ar.com.ciu.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import ar.com.ciu.model.StudentCourse;

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
	}

	public MarkDTO() {
		super();
	}
}
