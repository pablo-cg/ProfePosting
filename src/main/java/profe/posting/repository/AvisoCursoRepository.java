package profe.posting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import profe.posting.model.AvisoCurso;

@Repository
public interface AvisoCursoRepository extends CrudRepository<AvisoCurso, Long> {

}
