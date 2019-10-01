package ar.com.ciu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "Student")
@Table(name = "student")
public class Student {

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "nativoDeBaseDeDatos")
	@GenericGenerator(name = "nativoDeBaseDeDatos", strategy = "native")
	private Long id;
	
	@Column(nullable = false)
	@Type(type = "integer")
	private Integer dni;
	
	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String surname;
	
	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String name;
	
	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String mail;
	
	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String tel_principal;
	
	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String tel_secundario;
	
	
	//CONSTRUCTORES
	public Student() {
		super();
	}
	
	public Student(Integer dni, String surname, String name, String mail, String tel_principal, String tel_secundario) {
		super();
		this.dni = dni;
		this.surname = surname;
		this.name = name;
		this.mail = mail;
		this.tel_principal = tel_principal;
		this.tel_secundario = tel_secundario;
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
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
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


	public Integer getDni() {
		return dni;
	}


	public void setDni(Integer dni) {
		this.dni = dni;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getTel_principal() {
		return tel_principal;
	}


	public void setTel_principal(String tel_principal) {
		this.tel_principal = tel_principal;
	}


	public String getTel_secundario() {
		return tel_secundario;
	}


	public void setTel_secundario(String tel_secundario) {
		this.tel_secundario = tel_secundario;
	}
	
	
}
