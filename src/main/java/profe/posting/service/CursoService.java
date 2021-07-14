package profe.posting.service;

import profe.posting.model.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> obtenerTodos();

    void guardarCurso(Curso nuevoCurso);

    Curso encontrarCursoPorId(Long idCurso);

    boolean existeElCurso(Long idCurso);

    void eliminarCursoPorId(Long idCurso);
}
