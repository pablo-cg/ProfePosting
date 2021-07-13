package profe.posting.service.impl;

import org.springframework.stereotype.Service;
import profe.posting.model.AreaAprendizaje;
import profe.posting.repository.AreaAprendizajeRepository;
import profe.posting.service.AreaAprendizajeService;

import java.util.List;

@Service
public class AreaAprendizajeServiceImpl implements AreaAprendizajeService {

    final AreaAprendizajeRepository areaRepository;

    public AreaAprendizajeServiceImpl(AreaAprendizajeRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public List<AreaAprendizaje> listarAreas() {
        return (List<AreaAprendizaje>) areaRepository.findAll();
    }
}
