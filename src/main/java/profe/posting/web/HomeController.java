package profe.posting.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import profe.posting.service.CursoService;
import profe.posting.utils.Utilidades;

@Controller()
@RequestMapping()
public class HomeController {

    private final CursoService cursoService;

    public HomeController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping()
    public String Index(Model model) {
        return "Index";
    }

    @GetMapping("/login")
    public String mostrarInicioSesion() {
        return "Login";
    }

    @GetMapping("/loginAlt")
    public String mostrarInicioSesionAlt() {
        return "IniciarSesion";
    }

    @RequestMapping("/buscar")
    public String buscarCursos(@RequestParam(value = "busqueda") String cursoABuscar){
        return "ListaCursos";
    }

}
