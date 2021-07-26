package profe.posting.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import profe.posting.enums.RolNombre;
import profe.posting.model.Rol;
import profe.posting.service.RolService;

@Service
public class DatabaseCmd implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
//        Rol rolAlumno = new Rol(RolNombre.ROLE_ALUMNO);
//        Rol rolProfesor = new Rol(RolNombre.ROLE_PROFESOR);
//        rolService.guardar(rolAlumno);
//        rolService.guardar(rolProfesor);
    }
}
