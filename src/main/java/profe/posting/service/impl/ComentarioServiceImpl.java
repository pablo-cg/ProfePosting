package profe.posting.service.impl;

import org.springframework.stereotype.Service;
import profe.posting.model.Comentario;
import profe.posting.repository.ComentarioRepository;
import profe.posting.service.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    final ComentarioRepository comentarioRepository;

    public ComentarioServiceImpl(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public void agregarComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }
}
