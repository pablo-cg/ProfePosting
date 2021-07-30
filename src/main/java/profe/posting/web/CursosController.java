package profe.posting.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import profe.posting.enums.RolNombre;
import profe.posting.model.Comentario;
import profe.posting.model.Curso;
import profe.posting.security.model.UsuarioPrincipal;
import profe.posting.service.AreaAprendizajeService;
import profe.posting.service.ComentarioService;
import profe.posting.service.CursoService;
import profe.posting.service.UsuarioService;
import profe.posting.utils.Utilidades;

import java.security.Principal;
import java.util.Collection;
import java.util.Date;

@Controller
@RequestMapping()
public class CursosController {

    private final AreaAprendizajeService areaAprendizajeService;
    private final CursoService cursoService;
    private final UsuarioService usuarioService;
    private final ComentarioService comentarioService;

    public CursosController(AreaAprendizajeService areaAprendizajeService, CursoService cursoService, UsuarioService usuarioService, ComentarioService comentarioService) {
        this.areaAprendizajeService = areaAprendizajeService;
        this.cursoService = cursoService;
        this.usuarioService = usuarioService;
        this.comentarioService = comentarioService;
    }

    @GetMapping("/cursos")
    public String MisCursos(Model model, Principal principal) {
        var usuario = usuarioService.obtenerPorCorreo(principal.getName()).get();
        if (usuario.getRoles().stream().anyMatch(rol -> rol.getNombreRol().equals(RolNombre.ROLE_PROFESOR))){
            var cursos = Utilidades.calcularPuntuacion(cursoService.obtenerCursoPorIdProfesor(usuario.getIdUsuario()));
            model.addAttribute("cursos", cursos);
            return "Cursos";
        }
        var cursos = Utilidades.calcularPuntuacion(cursoService.obtenerTodos());
        model.addAttribute("cursos", cursos);
//        model.addAttribute("esDelProfe", true);
        return "Cursos";
    }

    @GetMapping("/cursos/todos")
    public String TodosLosCursos(Model model){
        var cursos = Utilidades.calcularPuntuacion(cursoService.obtenerTodos());
        model.addAttribute("cursos", cursos);
        return "Cursos";
    }

    @PreAuthorize("hasAnyRole('PROFESOR','ADMIN')")
    @GetMapping("/cursos/tabla")
    public String MisCursosTabla(Model model, Principal principal) {
        var usuario = usuarioService.obtenerPorCorreo(principal.getName()).get();
        if (usuario.getRoles().stream().anyMatch(rol -> rol.getNombreRol().equals(RolNombre.ROLE_PROFESOR))){
            var cursos = Utilidades.calcularPuntuacion(cursoService.obtenerCursoPorIdProfesor(usuario.getIdUsuario()));
            model.addAttribute("cursos", cursos);
            return "TablaCursos";
        }
        var cursos = Utilidades.calcularPuntuacion(cursoService.obtenerTodos());
        model.addAttribute("cursos", cursos);
        return "TablaCursos";
    }

    @PreAuthorize("hasAnyRole('PROFESOR','ADMIN')")
    @GetMapping("/cursos/nuevoCurso")
    public String nuevoCurso(Model model, Principal principal) {
        var idUsuario = usuarioService.obtenerPorCorreo(principal.getName()).get().getIdUsuario();
        var cursoNuevo = new Curso();
        cursoNuevo.setIdUsuarioProfesor(idUsuario);
        model.addAttribute("cursoNuevo", cursoNuevo);
        model.addAttribute("areas", areaAprendizajeService.listarAreas());
        return "NuevoCurso";
    }

    @PreAuthorize("hasAnyRole('PROFESOR','ADMIN')")
    @PostMapping("/cursos/agregarCurso")
    public String agregarCurso(@ModelAttribute("cursoNuevo") Curso curso) {
        cursoService.guardarCurso(curso);
        return "redirect:/cursos?agregado";
    }

    @PreAuthorize("hasAnyRole('PROFESOR','ADMIN')")
    @GetMapping("/cursos/modificarCurso")
    public String modificarCurso(@ModelAttribute("idCurso") Long idCurso, Model model) {
        // obtener curso desde el service
        Curso elCurso = cursoService.encontrarCursoPorId(idCurso);
        // definir el curso como un atributo del modelo para llenar el formulario
        model.addAttribute("cursoAModificar", elCurso);
        model.addAttribute("areas", areaAprendizajeService.listarAreas());
        // enviar hacia el formulario
        return "ModificarCurso";
    }

    @PreAuthorize("hasAnyRole('PROFESOR','ADMIN')")
    @PostMapping("/cursos/actualizarCurso")
    public String modificaCurso(@ModelAttribute("cursoNuevo") Curso curso) {
        cursoService.guardarCurso(curso);
        return "redirect:/cursos?modificado";
    }

    @PreAuthorize("hasAnyRole('PROFESOR','ADMIN')")
    @PostMapping("/cursos/eliminarCurso")
    public String eliminarCurso(@ModelAttribute("idCurso") Curso curso) {
        cursoService.eliminarCursoPorId(curso.getId());
        return "redirect:/cursos?eliminado";
    }

    @GetMapping("cursos/comentariosCurso")
    public String verComentariosCurso(@ModelAttribute("idCurso") Long idCurso, Model model, Principal principal) {
        Curso elCurso = Utilidades.calcularPuntuacion(cursoService.encontrarCursoPorId(idCurso));
        var idUsuario = usuarioService.obtenerPorCorreo(principal.getName()).get().getIdUsuario();
        Comentario nuevoComentario = new Comentario();
        nuevoComentario.setIdUsuarioAlumno(idUsuario);
        nuevoComentario.setIdCurso(elCurso.getId());
        model.addAttribute("nuevoComentario", nuevoComentario);
        model.addAttribute("curso", elCurso);
        model.addAttribute("agregado", false);
        return "ComentariosCurso";
    }

    @PostMapping("/cursos/comentar")
    public String comentarCurso(@ModelAttribute("nuevoComentario") Comentario comentario) {
        comentario.setHora(new Date());
        comentario.setEsValido(true);
        comentarioService.agregarComentario(comentario);
        var url = "/cursos/comentariosCurso?idCurso="+comentario.getIdCurso()+"&agregado";
        return "redirect:"+url;
    }

    @GetMapping("/cursos/buscar")
    public String buscarCursos(@ModelAttribute("texto") String texto, Model model) {
        var cursos = Utilidades.calcularPuntuacion(cursoService.buscarCursoPorTituloOArea("*"+texto+"*"));
        model.addAttribute("cursos", cursos);
        return "Cursos";
    }
}
