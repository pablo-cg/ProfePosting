package profe.posting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import profe.posting.model.ListaAlumno;

@Repository
public interface ListaAlumnoRepository extends CrudRepository<ListaAlumno, Long> {
}
