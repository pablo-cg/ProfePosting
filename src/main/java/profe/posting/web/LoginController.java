package profe.posting.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/iniciarSesion")
    public String mostrarInicioSesion() {
        return "IniciarSesion";
    }
}
