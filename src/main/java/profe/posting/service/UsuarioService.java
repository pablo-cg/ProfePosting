package profe.posting.service;

import profe.posting.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> obtenerUsuarios();

    Optional<Usuario> obtenerPorId(Long id);

    Optional<Usuario> obtenerPorCorreo(String correo);

    boolean existeCorreo(String correo);

    boolean existePorId(Long id);

    void crearUsuario(Usuario usuario);
}
