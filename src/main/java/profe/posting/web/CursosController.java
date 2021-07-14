package profe.posting.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import profe.posting.model.Curso;
import profe.posting.service.AreaAprendizajeService;
import profe.posting.service.CursoService;
import profe.posting.utils.Utilidades;

@Controller
@RequestMapping()
public class CursosController {

    private final AreaAprendizajeService areaAprendizajeService;
    private final CursoService cursoService;

    public CursosController(AreaAprendizajeService areaAprendizajeService, CursoService cursoService) {
        this.areaAprendizajeService = areaAprendizajeService;
        this.cursoService = cursoService;
    }

    @GetMapping("/profesor/misCursos")
    public String MisCursos(Model model) {
        var cursos = Utilidades.calcularPuntuacion(cursoService.obtenerTodos());
        model.addAttribute("cursos", cursos);
        return "MisCursos";
    }

    @GetMapping("/profesor/nuevoCurso")
    public String nuevoCurso(Model model) {
        model.addAttribute("cursoNuevo", new Curso());
        model.addAttribute("areas", areaAprendizajeService.listarAreas());
        return "NuevoCurso";
    }

    @PostMapping("/profesor/agregarCurso")
    public String agregarCurso(@ModelAttribute("cursoNuevo") Curso curso) {
        cursoService.guardarCurso(curso);
        return "redirect:/profesor/misCursos?agregado";
    }

    @GetMapping("/profesor/modificarCurso")
    public String modificarCurso(@ModelAttribute("idCurso") Long idCurso, Model model) {
        // obtener curso desde el service
        Curso elCurso = cursoService.encontrarCursoPorId(idCurso);
        // definir el curso como un atributo del modelo para llenar el formulario
        model.addAttribute("cursoAModificar", elCurso);
        model.addAttribute("areas", areaAprendizajeService.listarAreas());
        // enviar hacia el formulario
        return "ModificarCurso";
    }

    @PostMapping("/profesor/actualizarCurso")
    public String modificaCurso(@ModelAttribute("cursoNuevo") Curso curso) {
        cursoService.guardarCurso(curso);
        return "redirect:/profesor/misCursos?modificado";
    }

    @PostMapping("/profesor/eliminarCurso")
    public String eliminarCurso(@ModelAttribute("idCurso") Curso curso) {
        cursoService.eliminarCursoPorId(curso.getId());
        return "redirect:/profesor/misCursos?eliminado";
    }

    @GetMapping("profesor/comentariosCurso")
    public String verComentariosCurso(@ModelAttribute("idCurso") Long idCurso, Model model) {
        Curso elCurso = Utilidades.calcularPuntuacion(cursoService.encontrarCursoPorId(idCurso));
        //Curso elCurso = cursoService.encontrarCursoPorId(idCurso);
        model.addAttribute("curso", elCurso);
        return "ComentariosCurso";
    }
}
