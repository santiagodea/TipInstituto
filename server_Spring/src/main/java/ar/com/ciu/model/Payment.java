package ar.com.ciu.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Payment")
@Table(name = "payment")
public class Payment {

	private Long id;
	private String month;
	private LocalDate date_payment;
	private Long amount;
	private Student student;
	
	
	
	
public Payment() {
	
}
}
