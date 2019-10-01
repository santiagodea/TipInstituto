package ar.com.ciu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "Course")
@Table(name = "course")
public class Course {

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "nativoDeBaseDeDatos")
	@GenericGenerator(name = "nativoDeBaseDeDatos", strategy = "native")
	private Long id;
	
	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String name;
	
	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String level;
	
	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String shift; // es el turno en el cual se dicta el curso, maniana/tarde/noche
	
	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String teacher;
	
	@Type(type = "integer")
	private Integer startTime; // es la hora de comienzo del curso antes era hour

	// CONSTRUCTORES
	public Course() {
		super();
	}
	public Course(String name, String level, String shift, String teacher, Integer hour) {
		super();
		this.name = name;
		this.level = level;
		this.shift = shift;
		this.teacher = teacher;
		this.startTime = hour;
		
	}
	
	//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	//SETTERS AND GETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer hour) {
		this.startTime = hour;
	}
		
}
