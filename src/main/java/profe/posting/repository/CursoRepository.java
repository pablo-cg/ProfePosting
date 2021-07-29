package profe.posting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import profe.posting.model.Curso;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM curso\n" +
            "     where match (titulo) against (:texto in boolean mode)\n" +
            "     or areaaprendizaje_id in (" +
            "select id from areaaprendizaje " +
            "where match (nombre) against (:texto in boolean mode))")
    List<Curso> buscarCursoPorTituloOArea(@Param("texto") String texto);

    List<Curso> findAllByIdUsuarioProfesor(Long idUsuarioProfesor);
}
