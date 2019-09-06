package ar.com.ciu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.ciu.model.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {		// Le indico el tipo de dato y la primary key
}
