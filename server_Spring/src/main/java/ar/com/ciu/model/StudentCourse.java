package ar.com.ciu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

public class StudentCourse {

	
	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "nativoDeBaseDeDatos")
	@GenericGenerator(name = "nativoDeBaseDeDatos", strategy = "native")
	private Long id;
	
	private Student student;
	private Course course;
	
	@Column(nullable = false)
	@Type(type = "integer")
	private Integer year;
	
	//
	private List<Mark> marks;
	
	public StudentCourse() {
		super();
	}
}
