package profe.posting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import profe.posting.model.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
}
