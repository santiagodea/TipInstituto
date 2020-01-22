package ar.com.ciu.service;

import java.util.List;

import ar.com.ciu.dto.PaymentByStudentDTO;
import ar.com.ciu.dto.PaymentDTO;
import ar.com.ciu.model.Payment;

public interface PaymentService {
	public PaymentDTO create(PaymentDTO paymentDTO);
	
	public Payment create (Payment payment);

	public PaymentDTO findById(Long idPayment);

	public List<PaymentDTO> findAll();

	public PaymentDTO update(PaymentDTO paymentDTO);

	PaymentByStudentDTO paymentsByStudent(Long idStudent);

	PaymentDTO deleteById(PaymentDTO paymentDTO);
}
