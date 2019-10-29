package ar.com.ciu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.com.ciu.model.Mark;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Long> {		// Le indico el tipo de dato y la primary key
	
	@Query("SELECT m FROM Mark m WHERE m.studentCourse.id = :id")
	public List<Mark> findByIdSC(@Param("id") Long id);
	
}
