package ar.com.ciu.model;

import java.util.List;

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

	// atributos
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
	private String duty;
	
	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String teacher;
	
	@Type(type = "integer")
	private Long hour;

	// CONSTRUCTORES
	public Course() {
		super();
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

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Long getHour() {
		return hour;
	}

	public void setHour(Long hour) {
		this.hour = hour;
	}
	
	

	
}
