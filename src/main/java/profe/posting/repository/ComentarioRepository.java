package profe.posting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import profe.posting.model.Comentario;

@Repository
public interface ComentarioRepository extends CrudRepository<Comentario, Long> {
}
