package ar.com.ciu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Course")
@Table(name = "course")
public class Course {

	
	// ATRIBUTOS
	private Long id;
	private String name;
	private String level;
	private String duty;
	private Integer hour;
	private String teacher;
	private List<Student> students;
	
	//CONSTRUCTOR
	public Course() {
		
	}
	
	

}
