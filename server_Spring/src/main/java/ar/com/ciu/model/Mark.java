package ar.com.ciu.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "Mark")
@Table(name = "mark")
public class Mark {

	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "nativoDeBaseDeDatos")
	@GenericGenerator(name = "nativoDeBaseDeDatos", strategy = "native")
	private Long id;
	
	@Type(type = "integer")
	private Integer calification;
	
	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String unit;
	
	@Column(nullable = false)
	private LocalDate date;
	
	
	private StudentCourse studentCourse;

	public Mark() {
		super();
	}

}
