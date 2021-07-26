package profe.posting.service;

import profe.posting.enums.RolNombre;
import profe.posting.model.Rol;

import java.util.Optional;

public interface RolService {

    void guardar(Rol rol);

    Optional<Rol> obtenerPorRolNombre(RolNombre rolNombre);

    boolean existeRolNombre(RolNombre rolNombre);
}
