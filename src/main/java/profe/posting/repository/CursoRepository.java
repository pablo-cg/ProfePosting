package profe.posting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import profe.posting.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
