package profe.posting.service.impl;

import org.springframework.stereotype.Service;
import profe.posting.model.Curso;
import profe.posting.repository.CursoRepository;
import profe.posting.service.CursoService;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    @Override
    public void guardarCurso(Curso nuevoCurso) {
        cursoRepository.save(nuevoCurso);
    }

    @Override
    public Curso encontrarCursoPorId(Long idCurso) {
        return cursoRepository.findById(idCurso).get();
    }

    @Override
    public boolean existeElCurso(Long idCurso) {
        return cursoRepository.existsById(idCurso);
    }

    @Override
    public void eliminarCursoPorId(Long idCurso) {
        cursoRepository.deleteById(idCurso);
    }
}
