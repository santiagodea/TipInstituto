package ar.com.ciu.dto;

import java.time.LocalDate;

import ar.com.ciu.model.Payment;

public class PaymentDTO {

	// ATRIBUTOS
	private Long id;
	private String month;
	private LocalDate date_payment;
	private double amount;
	private Long idStudent;
	private LocalDate date_deleted;

	public PaymentDTO() {
		super();
	}

	public PaymentDTO(String month, LocalDate date, double amount, Long idStudent) {
		super();
		this.month = month;
		this.date_payment = date;
		this.amount = amount;
		this.idStudent = idStudent;
		this.date_deleted = null;

	}

	public PaymentDTO(Payment payment) {
		this(payment.getMonth(), payment.getDate_payment(), payment.getAmount(), payment.getStudent().getId());
		this.id = payment.getId();
	}

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

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public LocalDate getDate_deleted() {
		return date_deleted;
	}

	public void setDate_deleted(LocalDate date_deleted) {
		this.date_deleted = date_deleted;
	}

}
