package ar.com.ciu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.com.ciu.model.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {	// Le indico el tipo de dato y la primary key
	
	@Query("SELECT p FROM Payment p WHERE p.student.id = :id")
	public List<Payment> findByIdStudent(@Param("id") Long id);

}