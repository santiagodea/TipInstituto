package ar.com.ciu.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

public class StudentCourse {

	
	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "nativoDeBaseDeDatos")
	@GenericGenerator(name = "nativoDeBaseDeDatos", strategy = "native")
	private Long id;
	
	@Column(nullable = false)
	@Type(type = "integer")
	private Integer year;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private Student student;
	 
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private Course course;
	
	@OneToMany(mappedBy = "studentCourse", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Mark> marks;
	
	//CONSTRUCTORES
	public StudentCourse() {
		super();
	}
	public StudentCourse(Integer year, Student student, Course course) {
		super();
		this.year = year;
		this.student = student;
		this.course = course;
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
		if (!(obj instanceof StudentCourse))
			return false;
		StudentCourse other = (StudentCourse) obj;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}
	
	public void addMark(Mark mark) {
		this.marks.add(mark);
	}
	
}
