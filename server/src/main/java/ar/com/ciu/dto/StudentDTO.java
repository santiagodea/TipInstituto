package ar.com.ciu.dto;

import ar.com.ciu.model.Student;

public class StudentDTO {
	// ATRIBUTOS
	private Long id;
	private Integer dni;
	private String surname;
	private String name;
	private String mail;
	private String tel_principal;
	private String tel_secundario;

	public StudentDTO(){
		super();
	}
	
	public StudentDTO(Integer dni, String surname, String name, String mail, String tel_principal, String tel_secundario){
		super();
		this.dni = dni;
		this.surname = surname;
		this.name = name;
		this.mail = mail;
		this.tel_principal = tel_principal;
		this.tel_secundario = tel_secundario;
	}
	public StudentDTO(Student student){
		this(student.getDni(), student.getSurname(), student.getName(), student.getMail(), student.getTel_principal(), student.getTel_secundario());
		this.id = student.getId();
	}

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
