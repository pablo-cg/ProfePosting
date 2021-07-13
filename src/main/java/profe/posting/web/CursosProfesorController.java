package profe.posting.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import profe.posting.model.AvisoCurso;
import profe.posting.service.AreaAprendizajeService;
import profe.posting.service.AvisoCursoService;
import profe.posting.utils.Utilidades;

@Controller
@RequestMapping()
public class CursosProfesorController {

    private final AreaAprendizajeService areaAprendizajeService;
    private final AvisoCursoService avisoCursoService;

    public CursosProfesorController(AreaAprendizajeService areaAprendizajeService, AvisoCursoService avisoCursoService) {
        this.areaAprendizajeService = areaAprendizajeService;
        this.avisoCursoService = avisoCursoService;
    }

    @GetMapping("/profesor/nuevoCurso")
    public String nuevoCurso(Model model) {
        model.addAttribute("cursoNuevo", new AvisoCurso());
        model.addAttribute("areas", areaAprendizajeService.listarAreas());
        return "NuevoCurso";
    }

    @PostMapping("/profesor/agregarCurso")
    public String agregarCurso(@ModelAttribute("cursoNuevo") AvisoCurso curso) {
        avisoCursoService.guardarCurso(curso);
        return "redirect:/profesor/misCursos?agregado";
    }

    @GetMapping("/profesor/modificarCurso")
    public String modificarCurso(@ModelAttribute("idCurso") Long idCurso, Model model) {
        // obtener curso desde el service
        AvisoCurso elCurso = avisoCursoService.encontrarCursoPorId(idCurso);
        // definir el curso como un atributo del modelo para llenar el formulario
        model.addAttribute("cursoAModificar", elCurso);
        model.addAttribute("areas", areaAprendizajeService.listarAreas());
        // enviar hacia el formulario
        return "ModificarCurso";
    }

    @PostMapping("/profesor/actualizarCurso")
    public String modificaCurso(@ModelAttribute("cursoNuevo") AvisoCurso curso) {
        avisoCursoService.guardarCurso(curso);
        return "redirect:/profesor/misCursos?modificado";
    }

    @PostMapping("/profesor/eliminarCurso")
    public String eliminarCurso(@ModelAttribute("idCurso") AvisoCurso curso) {
        avisoCursoService.eliminarCursoPorId(curso.getId());
        return "redirect:/profesor/misCursos?eliminado";
    }

    @GetMapping("profesor/comentariosCurso")
    public String verComentariosCurso(@ModelAttribute("idCurso") Long idCurso, Model model) {
        AvisoCurso elCurso = Utilidades.calcularPuntuacion(avisoCursoService.encontrarCursoPorId(idCurso));
        //AvisoCurso elCurso = avisoCursoService.encontrarCursoPorId(idCurso);
        model.addAttribute("curso", elCurso);
        return "ComentariosCurso";
    }
}
