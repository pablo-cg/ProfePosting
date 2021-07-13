package profe.posting.service;

import profe.posting.model.AvisoCurso;

import java.util.List;

public interface AvisoCursoService {
    List<AvisoCurso> obtenerTodos();
    void guardarCurso(AvisoCurso nuevoCursoDto);
    AvisoCurso encontrarCursoPorId(Long idCurso);
    boolean existeElCurso(Long idCurso);
    void eliminarCursoPorId(Long idCurso);
}
