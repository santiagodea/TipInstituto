package ar.com.ciu.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "Payment")
@Table(name = "payment")
public class Payment {

	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "nativoDeBaseDeDatos")
	@GenericGenerator(name = "nativoDeBaseDeDatos", strategy = "native")
	private Long id;
	
	@Column(length = 255, nullable = false)
	@Type(type = "string")
	private String month;
	
	@Column(nullable = false)
	private LocalDate date_payment;
	
	@Column(nullable = false)
	@Type(type = "double")
	private double amount;
	
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "studentId")
	private Student student;

	private LocalDate date_deleted;
	
	//CONSTRUCTORES
	public Payment() {
		super();
	}
	public Payment(String month, double amount, LocalDate date_payment, Student student) {
		super();
		this.month = month;
		this.amount = amount;
		this.date_payment = date_payment;
		this.student = student;
		this.date_deleted = null;
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
		if (!(obj instanceof Payment))
			return false;
		Payment other = (Payment) obj;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public LocalDate getDate_payment() {
		return date_payment;
	}

	public void setDate_payment(LocalDate date_payment) {
		this.date_payment = date_payment;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	public LocalDate getDate_deleted() {
		return date_deleted;
	}
	public void setDate_deleted(LocalDate date_deleted) {
		this.date_deleted = date_deleted;
	}
	
	
}
