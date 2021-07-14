package profe.posting.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idUsuario;

    private String nombre;

    @Column(name = "apellidopaterno")
    private String apellidoPaterno;

    @Column(name = "apellidomaterno")
    private String apellidoMaterno;

    private String telefono;

    @Email
    private String correo;

    private String contrasena;

    public Usuario() {
    }

}
