package profe.posting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import profe.posting.model.Profesor;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Long> {
}
