package ar.com.ciu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.ciu.model.Mark;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Long> {		// Le indico el tipo de dato y la primary key
}
