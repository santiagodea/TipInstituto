package ar.com.ciu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.ciu.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {		// Le indico el tipo de dato y la primary key
}
