package profe.posting.web;

import com.sun.xml.bind.v2.TODO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import profe.posting.service.AvisoCursoService;
import profe.posting.utils.Utilidades;

@Controller()
@RequestMapping()
public class HomeController {

    private final AvisoCursoService avisoCursoService;

    public HomeController(AvisoCursoService avisoCursoService) {
        this.avisoCursoService = avisoCursoService;
    }

    @GetMapping()
    public String Index(Model model) {
//        var cursos = Utilidades.calcularPuntuacion(avisoCursoService.obtenerTodos());
//        model.addAttribute("cursos", cursos);
        return "test";
    }

    @GetMapping("/alumno/listaCursos")
    public String ListaCursos(Model model) {
        var cursos = Utilidades.calcularPuntuacion(avisoCursoService.obtenerTodos());
        model.addAttribute("cursos", cursos);
        return "ListaCursos";
    }

    @GetMapping("/profesor/misCursos")
    public String MisCursos(Model model) {
        var cursos = Utilidades.calcularPuntuacion(avisoCursoService.obtenerTodos());
        model.addAttribute("cursos", cursos);
        return "MisCursos";
    }

    @RequestMapping("/buscar")
    public String buscarCursos(@RequestParam(value = "busqueda") String cursoABuscar){
        return "ListaCursos";
    }

/*
    TODO: hacer el metodo con la query en el repository
     redireccionar a la lista de cursos filtrados
     hacer la parte de los comentarios
     lo de el login se podria dejar pora la ultima semana
     query:
     SELECT * FROM profepostingbd.avisocurso
     where match (titulo) against ('*quimi*' in boolean mode)
     or AreaAprendizaje_id in (select id from areaaprendizaje where match (nombre) against ('*quimi*' in boolean mode))
*/
}
