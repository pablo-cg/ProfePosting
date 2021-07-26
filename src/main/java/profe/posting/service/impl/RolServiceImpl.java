package profe.posting.service.impl;

import org.springframework.stereotype.Service;
import profe.posting.enums.RolNombre;
import profe.posting.model.Rol;
import profe.posting.repository.RolRepository;
import profe.posting.service.RolService;

import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public void guardar(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public boolean existeRolNombre(RolNombre rolNombre) {
        return rolRepository.existsByNombreRol(rolNombre);
    }

    @Override
    public Optional<Rol> obtenerPorRolNombre(RolNombre rolNombre) {
        return rolRepository.findByNombreRol(rolNombre);
    }
}
