package profe.posting.service.impl;

import org.springframework.stereotype.Service;
import profe.posting.model.AvisoCurso;
import profe.posting.repository.AvisoCursoRepository;
import profe.posting.service.AvisoCursoService;

import java.util.List;

@Service
public class AvisoCursoServiceImpl implements AvisoCursoService {

    final AvisoCursoRepository avisoCursoRepository;

    public AvisoCursoServiceImpl(AvisoCursoRepository avisoCursoRepository) {
        this.avisoCursoRepository = avisoCursoRepository;
    }

    @Override
    public List<AvisoCurso> obtenerTodos() {
        return (List<AvisoCurso>) avisoCursoRepository.findAll();
    }

    @Override
    public void guardarCurso(AvisoCurso nuevoCurso) {
       avisoCursoRepository.save(nuevoCurso);
    }

    @Override
    public AvisoCurso encontrarCursoPorId(Long idCurso) {
        return avisoCursoRepository.findById(idCurso).get();
    }

    @Override
    public boolean existeElCurso(Long idCurso) {
        return avisoCursoRepository.existsById(idCurso);
    }

    @Override
    public void eliminarCursoPorId(Long idCurso) {
        avisoCursoRepository.deleteById(idCurso);
    }
}
