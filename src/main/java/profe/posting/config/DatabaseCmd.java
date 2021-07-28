package profe.posting.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import profe.posting.enums.RolNombre;
import profe.posting.model.Rol;
import profe.posting.model.Usuario;
import profe.posting.service.RolService;
import profe.posting.service.UsuarioService;

import java.util.HashSet;
import java.util.Set;

@Service
public class DatabaseCmd implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
//        crearRoles();
//        crearUsuarioAdmin();
    }

    void crearRoles(){
        Rol rolAlumno = new Rol(RolNombre.ROLE_ALUMNO);
        Rol rolProfesor = new Rol(RolNombre.ROLE_PROFESOR);
        rolService.guardar(rolAlumno);
        rolService.guardar(rolProfesor);
    }

    void crearUsuarioAdmin(){
        Usuario usuario = new Usuario();
        String contrasena = passwordEncoder.encode("admin");
        usuario.setNombre("admin");
        usuario.setApellidoPaterno("1");
        usuario.setCorreo("admin@profeposting.cl");
        usuario.setContrasena(contrasena);
        Rol rolProfe = rolService.obtenerPorRolNombre(RolNombre.ROLE_PROFESOR).get();
        Rol rolAlumno = rolService.obtenerPorRolNombre(RolNombre.ROLE_ALUMNO).get();
        Set<Rol> roles = new HashSet<>();
        roles.add(rolProfe);
        roles.add(rolAlumno);
        usuario.setRoles(roles);
        usuarioService.crearUsuario(usuario);
    }
}
