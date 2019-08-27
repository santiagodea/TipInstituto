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

@Entity(name = "Payment")
@Table(name = "payment")
public class Payment {

	// atributos
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
	@Type(type = "integer")
	private Long amount;
	
	
	private Student student;

	public Payment() {
		super();
	}
}
