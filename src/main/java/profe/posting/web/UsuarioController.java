package profe.posting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;
import profe.posting.enums.RolNombre;
import profe.posting.model.Rol;
import profe.posting.model.Usuario;
import profe.posting.service.RolService;
import profe.posting.service.UsuarioService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/registro")
    public String Registro(){
        return "Register";
    }

    @PostMapping("/registrar")
    public ModelAndView Registrar(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono,String correo, String contrasena, String rol){
        ModelAndView mv = new ModelAndView();
        if (StringUtils.isEmptyOrWhitespace(nombre)){
            mv.setViewName("Register");
            mv.addObject("errorNombre", "El nombre no puede estar vacio");
            return mv;
        }
        if (StringUtils.isEmptyOrWhitespace(apellidoPaterno)){
            mv.setViewName("Register");
            mv.addObject("errorApellido", "El apellido paterno no puede estar vacio");
            return mv;
        }
        if (StringUtils.isEmptyOrWhitespace(correo)){
            mv.setViewName("Register");
            mv.addObject("errorCorreo", "El correo no puede estar vacio");
            return mv;
        }
        if (StringUtils.isEmptyOrWhitespace(contrasena)){
            mv.setViewName("Register");
            mv.addObject("errorContrasena", "La contraseña no puede estar vacio");
            return mv;
        }
        if (StringUtils.isEmptyOrWhitespace(rol)){
            mv.setViewName("Register");
            mv.addObject("errorRol", "Debes elegir un rol");
            return mv;
        }
        if (usuarioService.existeCorreo(correo)){
            mv.setViewName("Register");
            mv.addObject("usuarioExiste", "Tu correo ya está registrado, inicia sesión");
            return mv;
        }
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellidoPaterno(apellidoPaterno);
        usuario.setApellidoMaterno(apellidoMaterno);
        usuario.setTelefono("+56"+telefono);
        usuario.setCorreo(correo);
        usuario.setContrasena(passwordEncoder.encode(contrasena));
        Rol rolUsuario = new Rol();
        switch (rol){
            case "ROLE_PROFESOR":
                rolUsuario = rolService.obtenerPorRolNombre(RolNombre.ROLE_PROFESOR).get();
                break;
            case "ROLE_ALUMNO":
                rolUsuario = rolService.obtenerPorRolNombre(RolNombre.ROLE_ALUMNO).get();
                break;
        }
        Set <Rol> roles = new HashSet<>();
        roles.add(rolUsuario);
        usuario.setRoles(roles);
        usuarioService.crearUsuario(usuario);
        mv.setViewName("/login");
        mv.addObject("registroOK","Felicidades "+usuario.getNombre()+" has creado una cuenta en ProfePosting, ahora puedes iniciar sesión");
        return mv;
    }

}
