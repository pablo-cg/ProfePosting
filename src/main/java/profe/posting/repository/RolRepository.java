package profe.posting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import profe.posting.enums.RolNombre;
import profe.posting.model.Rol;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByNombreRol(RolNombre nombreRol);

    boolean existsByNombreRol(RolNombre nombreRol);
}
