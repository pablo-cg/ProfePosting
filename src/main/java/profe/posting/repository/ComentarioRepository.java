package profe.posting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import profe.posting.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
