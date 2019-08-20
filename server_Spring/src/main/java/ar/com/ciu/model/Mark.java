package ar.com.ciu.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Mark")
@Table(name = "mark")
public class Mark {

	private Long id;
	private Integer calification;
	private String unit;
	private LocalDate date;
	private Student student;
	
public Mark() {
	
}
	
	
}
