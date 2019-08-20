package ar.com.ciu.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Student")
@Table(name = "student")
public class Student {

	//ATRIBUTOS
	private Long id;
	private Integer dni;
	private String surname;
	private String name;
	private String mail;
	private String tel_principal;
	private String tel_secundario;
	
	
	//CONSTRUCTOR
	public Student() {
		
	}
}
