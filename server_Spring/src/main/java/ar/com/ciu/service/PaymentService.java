package ar.com.ciu.service;

import java.util.List;

import ar.com.ciu.dto.PaymentDTO;

public interface PaymentService {
	public PaymentDTO create(PaymentDTO paymentDTO);

	public PaymentDTO finById(Long idPayment);

	public List<PaymentDTO> findAll();

	public PaymentDTO update(PaymentDTO paymentDTO);

	public void delete(Long idPayment);
}
